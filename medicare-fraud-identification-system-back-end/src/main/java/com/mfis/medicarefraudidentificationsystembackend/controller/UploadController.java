package com.mfis.medicarefraudidentificationsystembackend.controller;

import com.mfis.medicarefraudidentificationsystembackend.pojo.Result;
import com.mfis.medicarefraudidentificationsystembackend.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/csv")
    public Result uploadCsvFile(@RequestParam("csvFile") MultipartFile csvFile) throws IOException {
        // 检查文件是否为空
        if (csvFile.isEmpty()) {
            return Result.error("上传文件为空");
        }

        // 检查文件类型
        String contentType = csvFile.getContentType();
        if (!contentType.startsWith("text/csv")) {
            return Result.error("文件类型错误");
        }

        // 直接将MultipartFile对象传给Service层
        uploadService.processCsvFile(csvFile);
        return Result.success("上传成功");

    }
}
