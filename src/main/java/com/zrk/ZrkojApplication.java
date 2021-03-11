package com.zrk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.zrk.mapper")
@ServletComponentScan
public class ZrkojApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZrkojApplication.class, args);
    }

}
