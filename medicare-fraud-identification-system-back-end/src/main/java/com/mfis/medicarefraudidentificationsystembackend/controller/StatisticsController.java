package com.mfis.medicarefraudidentificationsystembackend.controller;

import com.mfis.medicarefraudidentificationsystembackend.pojo.Result;
import com.mfis.medicarefraudidentificationsystembackend.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("http://localhost:5173")
@RestController
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;


    @GetMapping("/getPieChartConverter")
    public Result getPieChartConverter() {
        return Result.success(statisticsService.getPieChartConverter());
    }

    @GetMapping("/getFraudsterData")
    public Result getFraudsterData() {
        return Result.success(statisticsService.getFraudsterData());
    }

    @GetMapping("test")
    public Result test() {
        return Result.success("hello world!");
    }
}
