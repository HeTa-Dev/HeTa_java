package com.heta.controller;

import com.heta.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

// 用来处理OSS服务器的相关请求，例如上传和删除文件
@RestController
@RequestMapping("/heta/oss")
public class OssController {

    @Autowired
    private OssService ossService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file")MultipartFile file){
        return ossService.uploadFile(file);
    }

    @DeleteMapping("/delete")
    public void deleteFile(@RequestParam("path") String path){
        ossService.deleteFile(path);
    }
}
