package com.operation.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
 public class MicroserviceOperationApi extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MicroserviceOperationApi.class);
    }

    public static void main(String[] args) {
        new SpringApplication(MicroserviceOperationApi.class).run(args);
    }

    @RestController
    class holaController{
        @GetMapping("/")
        String hello(){
            return ("DEPLOYE LA APP NENE");
        }
    }
}

