package com.example.demo;

import brave.Tracer;
import brave.Tracing;
import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Sender;
import zipkin2.reporter.okhttp3.OkHttpSender;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;


@SpringBootApplication
public class DemoApplication {
    @Bean
    public Sender sender() {
        return OkHttpSender.create("http://localhost:9411/api/v2/spans");
    }

    @Bean
    public Client client() {
        return ClientBuilder.newClient();
    }

    @Bean
    Tracing tracing() {
        return Tracing
                .newBuilder()
                .localServiceName("app1")
                .spanReporter(AsyncReporter.builder(OkHttpSender.create("http://localhost:9411/api/v2/spans")).build())
                .sampler(Sampler.ALWAYS_SAMPLE) /* or any other Sampler */
                .supportsJoin(true)
                .build();
    }

    @Bean
    Tracer tracer() {
        return tracing().tracer();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
