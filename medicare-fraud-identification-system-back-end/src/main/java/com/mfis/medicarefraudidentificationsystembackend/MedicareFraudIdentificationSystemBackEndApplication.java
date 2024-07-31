package com.mfis.medicarefraudidentificationsystembackend;

import com.mfis.medicarefraudidentificationsystembackend.utils.PmmlPredict;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedicareFraudIdentificationSystemBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicareFraudIdentificationSystemBackEndApplication.class, args);
        try {
            PmmlPredict.initModel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
