package com.example.demo.resource;

import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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