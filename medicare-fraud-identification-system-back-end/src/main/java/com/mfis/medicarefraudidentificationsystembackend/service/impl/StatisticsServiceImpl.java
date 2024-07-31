package com.mfis.medicarefraudidentificationsystembackend.service.impl;

import com.mfis.medicarefraudidentificationsystembackend.mapper.StatisticsMapper;
import com.mfis.medicarefraudidentificationsystembackend.pojo.CsvDataEntity;
import com.mfis.medicarefraudidentificationsystembackend.pojo.PieChartConverter;
import com.mfis.medicarefraudidentificationsystembackend.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsMapper statisticsMapper;
    @Override
    public List<PieChartConverter> getPieChartConverter() {
        List<PieChartConverter> pieData = new ArrayList<>();
        pieData.add(new PieChartConverter("医疗欺诈人数", statisticsMapper.getFraudsterNum()));
        pieData.add(new PieChartConverter("总记录人数", statisticsMapper.getTotalNum()));
        return pieData;
    }

    @Override
    public List<CsvDataEntity> getFraudsterData() {
        return statisticsMapper.getFraudsterData();
    }

}
