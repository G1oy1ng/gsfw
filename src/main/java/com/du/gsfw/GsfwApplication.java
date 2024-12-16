package com.du.gsfw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@MapperScan("com.du.gsfw.mapper")
public class GsfwApplication {

    public static void main(String[] args) {
        SpringApplication.run(GsfwApplication.class, args);
    }

}
