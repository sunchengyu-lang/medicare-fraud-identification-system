package com.mfis.medicarefraudidentificationsystembackend.utils;

import com.alibaba.fastjson.JSONObject;
import org.jpmml.evaluator.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PmmlPredict {

    //将模型定义为全局变量，springboot启动时加载pmml并初始化
    public static Evaluator evaluator;

    //模型初始化方法，springboot启动时执行该方法，然后初始化上面的Evaluator
    public static void initModel() throws IOException, SAXException, JAXBException, jakarta.xml.bind.JAXBException, ParserConfigurationException {
//        File file = new File("resources/pmml_models/rfc_model.pmml");
        InputStream pmmlInputStream = PmmlPredict.class.getResourceAsStream("/pmml_models/rfc_model.pmml");
        evaluator = new LoadingModelEvaluatorBuilder().load(pmmlInputStream).build();
        evaluator.verify();
    }

    //定义一个实用函数，就是python中的print函数，没别的意思
    public static void print(Object... args) {
        Arrays.stream(args).forEach(System.out::print);
        System.out.println("");
    }

    // 定义预测函数，htt请求该函数，然后返回预测值
    // 传入的参数是一个json，字段要求和模型的字段保持一致
    public static Integer predict(JSONObject feature) {
        // 获取模型定义的特征
        List<? extends InputField> inputFields = evaluator.getInputFields();
//        print("模型的特征是：", inputFields);
        // 获取模型定义的目标名称
        List<? extends TargetField> targetFields = evaluator.getTargetFields();
//        print("目标字段是：", targetFields);

        // 将json转成evaluator要求的map格式，其实就是对key和value再做一层包装而已
        Map<String, FieldValue> arguments = new LinkedHashMap<>();
        for (InputField inputField : inputFields) {
            String inputName = inputField.getName();
            String name = inputName;
            Object rawValue = feature.getDoubleValue(name);
            FieldValue inputValue = inputField.prepare(rawValue);
            arguments.put(inputName, inputValue);
        }
        // 得到特征数据后就是预测了
        Map<String, ?> results = evaluator.evaluate(arguments);
//        Class<?> objClass = results.get("RES").getClass();
        String s = results.get("RES").toString();
        Integer y = '0' == s.charAt(s.indexOf("result=") + 7) ? 0 : 1;
//        System.out.println(results.get("RES").toString());
//        System.out.println(objClass);

        Map<String, ?> resultRecord = (Map<String, ?>) EvaluatorUtil.decode(results);
        // 打印结果会更加了解其中的封装过程
//        print("预测结果：");
//        print(results);
//        print(resultRecord);
//        print(y);
        return y;
    }
}