package com.mfis.medicarefraudidentificationsystembackend.service;

import com.mfis.medicarefraudidentificationsystembackend.pojo.CsvDataEntity;
import com.mfis.medicarefraudidentificationsystembackend.pojo.PieChartConverter;

import java.util.List;

public interface StatisticsService {
    List<PieChartConverter> getPieChartConverter();


    List<CsvDataEntity> getFraudsterData();
}
