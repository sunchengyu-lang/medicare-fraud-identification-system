package com.mfis.medicarefraudidentificationsystembackend.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mfis.medicarefraudidentificationsystembackend.mapper.UploadMapper;
import com.mfis.medicarefraudidentificationsystembackend.pojo.CsvDataEntity;
import com.mfis.medicarefraudidentificationsystembackend.service.UploadService;
import com.mfis.medicarefraudidentificationsystembackend.utils.PmmlPredict;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private UploadMapper uploadMapper;

    @Override
    public void processCsvFile(MultipartFile csvFile) {

        //读取csv文件，并转成json格式，传给模型判断
        try (Reader reader = new InputStreamReader(csvFile.getInputStream(), StandardCharsets.UTF_8);
             CSVReader csvReader = new CSVReader(reader)) {

            //使用字符串读取csv文件
            String[] headers;

            if ((headers = csvReader.readNext()) != null) {
                int hLength = headers.length;
                String[] record;
                while ((record = csvReader.readNext()) != null) {
                    JSONObject jsonObject = new JSONObject();

                    for (int i = 0; i < hLength; i++) {

                        String value = record[i];
                        if(value.length() == 0)value = "0";
                        jsonObject.put(headers[i], value);
                    }
                    Integer res = PmmlPredict.predict(jsonObject);
                    jsonObject.put("RES", res);
                    CsvDataEntity cde = new CsvDataEntity(jsonObject);
                    saveData(cde);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveData(CsvDataEntity csvDataEntity) {
        uploadMapper.insert(csvDataEntity);
    }
}
