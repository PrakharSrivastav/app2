package com.example.demo.config;

import com.example.demo.resource.HelloResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

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