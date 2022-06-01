package com.chendb.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @Author chendengbin
 * @Date 2022/5/30 11:26
 * @Version 1.0
 **/
@SpringBootApplication
@MapperScan(value = "com.chendb.sharding.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
