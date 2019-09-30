package com.example.demo.service;

import brave.Tracing;
import com.example.demo.integration.HelloIntegration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.tracing.brave.jaxrs.BraveClientProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Sender;
import zipkin2.reporter.okhttp3.OkHttpSender;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;

@Component
public class HelloService {

    @Autowired
    HelloIntegration helloIntegration;

    public String hello() {
        return this.helloIntegration.hello();
    }
}