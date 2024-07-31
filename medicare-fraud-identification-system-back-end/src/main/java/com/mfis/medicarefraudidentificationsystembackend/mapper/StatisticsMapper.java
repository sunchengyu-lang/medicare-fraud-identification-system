package com.mfis.medicarefraudidentificationsystembackend.mapper;

import com.mfis.medicarefraudidentificationsystembackend.pojo.CsvDataEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StatisticsMapper {
    @Select("SELECT COUNT(*) FROM medical_insure_data WHERE RES = 1;")
    Integer getFraudsterNum();
    @Select("SELECT COUNT(*) FROM medical_insure_data;")
    Integer getTotalNum();
    @Select("SELECT 个人编码,就诊的月数,月统筹金额_MAX,月统筹金额_AVG,月药品金额_MAX,月药品金额_AVG," +
            "交易时间YYYYMM_NN,统筹支付金额_SUM,ALL_SUM,药品费自费金额_SUM,贵重药品发生金额_SUM," +
            "基本个人账户支付_SUM,本次审批金额_SUM,RES FROM medical_insure_data WHERE RES = 1;")
    List<CsvDataEntity> getFraudsterData();
}
