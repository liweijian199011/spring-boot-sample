package com.jack;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.jack.mapper")
@SpringBootApplication
public class MysqlReplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlReplicationApplication.class, args);
    }
}