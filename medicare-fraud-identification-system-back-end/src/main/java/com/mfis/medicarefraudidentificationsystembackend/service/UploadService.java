package com.mfis.medicarefraudidentificationsystembackend.service;

import com.mfis.medicarefraudidentificationsystembackend.pojo.CsvDataEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {


    void processCsvFile(MultipartFile csvFile) throws IOException;
    void saveData(CsvDataEntity csvDataEntity);
}
