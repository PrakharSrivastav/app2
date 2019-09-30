package com.example.demo.integration;

import brave.Tracer;
import brave.Tracing;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.tracing.brave.jaxrs.BraveClientProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Sender;
import zipkin2.reporter.okhttp3.OkHttpSender;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;

@Service
public class HelloIntegration {

    @Autowired
    private Sender sender;

    @Autowired
    private Tracing tracing;

    public String hello() {


        return WebClient.create("http://localhost:8082/reverse?data=regit", Arrays.asList(new BraveClientProvider(this.tracing)))
                .accept(MediaType.TEXT_PLAIN)
                .get(String.class);


    }
}