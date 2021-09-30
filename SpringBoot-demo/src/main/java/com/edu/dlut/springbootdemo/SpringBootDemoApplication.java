package com.edu.dlut.springbootdemo;

import com.edu.dlut.springbootdemo.controller.UserController;
import com.edu.dlut.springbootdemo.entity.User;
import com.edu.dlut.springbootdemo.service.UserService;
import com.edu.dlut.springbootdemo.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}
