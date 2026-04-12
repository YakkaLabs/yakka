package com.yakka.flex.generator.utils;

import com.yakka.basic.database.properties.DatabaseProperties;
import com.yakka.flex.generator.enumeration.ProjectTypeEnum;
import com.yakka.flex.generator.vo.save.ProjectGeneratorVO;

/**
 * @author Jared
 * @version v1.0
 * @date 2022/4/5 5:54 PM
 * @create [2022/4/5 5:54 PM ] [tangyh] [初始创建]
 */
public class ProjectUtilsTest {
    public static void main(String[] args) {
        ProjectGeneratorVO vo = new ProjectGeneratorVO();
        vo.setProjectPrefix("yakka");
        vo.setOutputDir("/Users/yakka/gitlab/yakka-cloud-pro-datasource-column");
        vo.setType(ProjectTypeEnum.CLOUD);
        vo.setAuthor("乾乾");
        vo.setServiceName("test");
        vo.setModuleName("test");
        vo.setParent("com.yakka.flex");
        vo.setGroupId("com.yakka.flex");
        vo.setUtilParent("com.yakka.basic");
        vo.setVersion("3.0.0");
        vo.setDescription("测试服务");
        vo.setServerPort(8080);
        ProjectUtils.generator(vo, new DatabaseProperties());
    }
}
