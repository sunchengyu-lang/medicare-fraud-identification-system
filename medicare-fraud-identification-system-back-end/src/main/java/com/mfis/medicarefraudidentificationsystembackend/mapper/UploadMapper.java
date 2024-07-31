package com.mfis.medicarefraudidentificationsystembackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.mfis.medicarefraudidentificationsystembackend.pojo.CsvDataEntity;
@Mapper
public interface UploadMapper extends BaseMapper<CsvDataEntity> {
}
