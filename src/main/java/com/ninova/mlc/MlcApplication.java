package com.ninova.mlc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages= {"com.ninova.mlc.data"})

public class MlcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MlcApplication.class, args);
    }

}
