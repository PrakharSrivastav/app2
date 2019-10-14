package com.example.demo.service;

import com.example.demo.integration.HelloIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloService {

    @Autowired
    HelloIntegration helloIntegration;

    public String hello() {
        return this.helloIntegration.hello();
    }
}