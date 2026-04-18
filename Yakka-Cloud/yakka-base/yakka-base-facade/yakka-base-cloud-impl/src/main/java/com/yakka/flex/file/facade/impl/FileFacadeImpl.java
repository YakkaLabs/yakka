package com.yakka.flex.file.facade.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.yakka.basic.base.R;
import com.yakka.flex.file.api.FileApi;
import com.yakka.flex.file.enumeration.FileStorageType;
import com.yakka.flex.file.facade.FileFacade;
import com.yakka.flex.file.vo.result.FileResultVO;

/**
 * 文件接口
 *
 * @author 乾乾
 * @since 2024年09月20日10:45:54
 */
@Service
public class FileFacadeImpl implements FileFacade {
    @Autowired
    @Lazy
    private FileApi fileApi;

    @Override
    public FileResultVO upload(MultipartFile file, String bizType, String bucket, FileStorageType storageType) {
        R<FileResultVO> result = fileApi.upload(file, bizType, bucket, storageType);
        return result.getData();
    }
}
