package com.anantha.apps.zuul_filter_logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulFilterLoggingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulFilterLoggingApplication.class, args);
    }

}
