package com.example.demo.config;

import brave.Tracing;
import brave.sampler.Sampler;
import com.example.demo.resource.HelloResource;
import org.apache.cxf.tracing.brave.jaxrs.BraveFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Sender;
import zipkin2.reporter.okhttp3.OkHttpSender;

@Component
public class JerseyConfig extends ResourceConfig {



    public JerseyConfig() {


//        final Tracing brave = Tracing
//                .newBuilder()
//                .localServiceName("app1")
//                .spanReporter(AsyncReporter.builder(OkHttpSender.create("http://localhost:9411/api/v2/spans")).build())
//                .sampler(Sampler.ALWAYS_SAMPLE) /* or any other Sampler */
//                .supportsJoin(true)
//                .build();


        register(HelloResource.class);
//        register(new BraveFeature(brave));
    }
}