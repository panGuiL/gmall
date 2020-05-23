package com.lpg.gmall.user;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lpg.gmall.mapper.user") // 如果需要用通用的mapper 需要导入 tk.mybatis.spring.annotation.MapperScan;
public class GmallUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallUserApplication.class, args);
    }

}
