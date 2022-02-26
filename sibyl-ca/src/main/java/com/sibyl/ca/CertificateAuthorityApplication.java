package com.sibyl.ca;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @Classname CertificateAuthorityApplication
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/26 09:52
 */
@SpringBootApplication
@MapperScan("com.sibyl.ca.mapper")

public class CertificateAuthorityApplication {
    public static void main(String[] args) {
        SpringApplication.run(CertificateAuthorityApplication.class,args);
    }
}
