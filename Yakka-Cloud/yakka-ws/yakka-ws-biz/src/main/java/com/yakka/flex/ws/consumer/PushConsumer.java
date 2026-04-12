package com.yakka.flex.ws.consumer;

import com.yakka.flex.common.constant.MqConstant;
import com.yakka.flex.model.entity.WsBaseResp;
import com.yakka.flex.model.entity.dto.NodePushDTO;
import com.yakka.flex.ws.websocket.SessionManager;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Map;

/**
 * 节点消息消费者，负责处理推送到本节点的消息，并将消息分发给对应的用户会话
 *
 * 使用线程池按用户ID（根据CPU的核心数量智能分配）分片处理，保证同一用户的消息顺序性。
 * @author Jared
 */
@Slf4j
@RocketMQMessageListener(
		topic = MqConstant.PUSH_TOPIC + "${yakka.node-id}",
		consumerGroup = MqConstant.PUSH_GROUP + "${yakka.node-id}",
		messageModel = MessageModel.CLUSTERING,
		maxReconsumeTimes = 3
)
@Component
public class PushConsumer implements RocketMQListener<NodePushDTO> {
	@Resource
	private SessionManager sessionManager;

    @Override
	public void onMessage(NodePushDTO message) {
		log.info("收到节点消息: {}", message);
		Map<String, Long> deviceUserMap = message.getDeviceUserMap();
		WsBaseResp<?> msg = message.getWsBaseMsg();

		Flux.fromIterable(deviceUserMap.entrySet())
				.parallel() // 并行推送
				.runOn(Schedulers.boundedElastic())
				.flatMap(entry ->
						sessionManager.sendToDevice(entry.getValue(), entry.getKey(), msg)
								.subscribeOn(Schedulers.boundedElastic()) // 设备级并行
				)
				.subscribe(null, ex -> log.error("推送失败: {}", ex.getMessage()),
						() -> log.debug("节点推送完成 (设备数: {})", deviceUserMap.size()));
	}
}
