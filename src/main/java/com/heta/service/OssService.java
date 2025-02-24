package com.heta.service;


import com.aliyun.oss.OSS;
import com.aliyun.oss.model.GenericRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

// OSS 服务类
@Service
public class OssService {

    @Autowired
    private OSS ossClient;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    // 向OSS服务器上传文件
    public String uploadFile(MultipartFile file) {
        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        try {
            ossClient.putObject(bucketName, fileName, file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return "https://" + bucketName + "." + endpoint + "/" + fileName;
    }

    // 向OSS服务器发送删除路径对应文件的指令
    public void deleteFile(String path){
        String fileName = path.substring(path.lastIndexOf("/") + 1);
        ossClient.deleteObject(new GenericRequest(bucketName, fileName));
    }
}
