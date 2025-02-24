package com.heta;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//这里是java后端Spring boot程序的入口方法
@SpringBootApplication
@MapperScan("com.heta")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
