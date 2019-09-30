package com.example.demo.resource;

import brave.Tracing;
import com.example.demo.service.HelloService;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.tracing.brave.jaxrs.BraveClientProvider;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Sender;
import zipkin2.reporter.okhttp3.OkHttpSender;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;

@Component
@Path("/hello")
public class HelloResource {

    @Autowired
    HelloService helloService;

    @GET
    @Produces("text/plain")
    public String hello() {
        return helloService.hello();
    }
}