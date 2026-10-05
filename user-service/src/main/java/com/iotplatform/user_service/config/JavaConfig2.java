package com.iotplatform.user_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class JavaConfig2 {

    @Bean
    public String javaConfig2() {
        return "JavaConfig2";
    }
}
