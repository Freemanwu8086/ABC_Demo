package com.freemanwu.abc_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.freemanwu.abc_demo.dao")
public class AbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbcDemoApplication.class, args);
    }

}
