package com.yakka.flex.file.api.fallback;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.yakka.basic.base.R;
import com.yakka.flex.file.api.FileApi;
import com.yakka.flex.file.enumeration.FileStorageType;
import com.yakka.flex.file.vo.result.FileResultVO;

/**
 * 熔断
 *
 * @author Jared
 * @date 2019/07/25
 */
@Component
public class FileApiFallback implements FileApi {
    @Override
    public R<FileResultVO> upload(MultipartFile file, String bizType, String bucket, FileStorageType storageType) {
        return R.timeout();
    }

}
