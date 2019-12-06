package com.example.demos;

import com.example.demos.config.Setup;
import com.example.demos.service.CallService;
import com.example.demos.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class DemosApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemosApplication.class, args);
    }

    @Bean(initMethod = "init")
    @Autowired
    public Setup tests(OperatorService operatorService, CallService callService) {
        return new Setup(operatorService, callService);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.parse("128MB"));
        factory.setMaxRequestSize(DataSize.parse("128MB"));
        return factory.createMultipartConfig();
    }
}
