package com.mfis.medicarefraudidentificationsystembackend.pojo;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("medical_insure_data")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CsvDataEntity {
    @NotNull
    private BigInteger 个人编码;
    private Integer 一天去两家医院的天数;
    private Integer 就诊的月数;
    private Double 月就诊天数_MAX;
    private Double 月就诊天数_AVG;
    private Integer 月就诊医院数_MAX;
    private Double 月就诊医院数_AVG;
    private Integer 就诊次数_SUM;
    private Integer 月就诊次数_MAX;
    private Double 月就诊次数_AVG;
    private Double 月统筹金额_MAX;
    private Double 月统筹金额_AVG;
    private Double 月药品金额_MAX;
    private Double 月药品金额_AVG;
    private Double 医院_就诊天数_MAX;
    private Double 医院_就诊天数_AVG;
    private Double 医院_统筹金_MAX;
    private Double 医院_统筹金_AVG;
    private Double 医院_药品_MAX;
    private Double 医院_药品_AVG;
    private Integer 医院编码_NN;
    private Integer 顺序号_NN;
    private Integer 交易时间DD_NN;
    private Integer 交易时间YYYY_NN;
    private Integer 交易时间YYYYMM_NN;
    private Integer 住院天数_SUM;
    private Double 个人账户金额_SUM;
    private Double 统筹支付金额_SUM;
    private Double ALL_SUM;
    private Double 可用账户报销金额_SUM;
    private Double 药品费发生金额_SUM;
    private Double 药品费自费金额_SUM;
    private Double 药品费申报金额_SUM;
    private Double 贵重药品发生金额_SUM;
    private Double 中成药费发生金额_SUM;
    private Double 中草药费发生金额_SUM;
    private Double 检查费发生金额_SUM;
    private Double 检查费自费金额_SUM;
    private Double 检查费申报金额_SUM;
    private Double 贵重检查费金额_SUM;
    private Double 治疗费发生金额_SUM;
    private Double 治疗费自费金额_SUM;
    private Double 治疗费申报金额_SUM;
    private Double 手术费发生金额_SUM;
    private Double 手术费自费金额_SUM;
    private Double 手术费申报金额_SUM;
    private Double 床位费发生金额_SUM;
    private Double 床位费申报金额_SUM;
    private Double 医用材料发生金额_SUM;
    private Double 高价材料发生金额_SUM;
    private Double 医用材料费自费金额_SUM;
    private Double 成分输血申报金额_SUM;
    private Double 其它发生金额_SUM;
    private Double 其它申报金额_SUM;
    private Double 一次性医用材料申报金额_SUM;
    private Double 起付线标准金额_MAX;
    private Double 起付标准以上自负比例金额_SUM;
    private Double 医疗救助个人按比例负担金额_SUM;
    private Double 最高限额以上金额_SUM;
    private Double 基本统筹基金支付金额_SUM;
    private Double 公务员医疗补助基金支付金额_SUM;
    private Double 城乡救助补助金额_SUM;
    private Double 基本个人账户支付_SUM;
    private Double 非账户支付金额_SUM;
    private Double 本次审批金额_SUM;
    private Double 补助审批金额_SUM;
    private Double 医疗救助医院申请_SUM;
    private Double 残疾军人补助_SUM;
    private Integer 民政救助补助_SUM;
    private Integer 城乡优抚补助_SUM;
    private Integer 出院诊断病种名称_NN;
    private Integer 出院诊断LENTH_MAX;
    private Double 药品在总金额中的占比;
    private Double 个人支付的药品占比;
    private Double 检查总费用在总金额占比;
    private Double 个人支付检查费用占比;
    private Double 治疗费用在总金额占比;
    private Double 个人支付治疗费用占比;
    private Integer BZ_民政救助;
    private Integer BZ_城乡优抚;
    private Integer 是否挂号;
    private Integer RES;


    public CsvDataEntity(JSONObject jsonObject) {

        Field[] fields = CsvDataEntity.class.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            if (jsonObject.containsKey(fieldName)) {
                try {
                    String t = jsonObject.getString(fieldName);
//                    System.out.println(fieldName + ":" + t);
                    // 判断并转换字段的类型，假设field可能是Double或Integer类型
                    if (field.getType() == Integer.class) {
                        field.set(this, Integer.parseInt(t));
                    } else if (field.getType() == Double.class) {
                        field.set(this, Double.parseDouble(t));
                    } else if (field.getType() == BigInteger.class) {
                        field.set(this, new BigInteger(t));
                    } else if (field.getType() == String.class) {
                        field.set(this, t);
                    } else {
                        // 添加对其他可能类型的处理，或者抛出异常
                        throw new IllegalArgumentException("Unsupported field type for field: " + fieldName);
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
