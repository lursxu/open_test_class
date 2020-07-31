package com.example.demo;

import com.example.demo.dao.SystemUserRepository;
import com.example.demo.entity.SystemUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootApplication
@ComponentScan(value = "com")
public class DemoApplicationTests {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }



}
