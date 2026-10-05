package com.iotplatform.user_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JavaConfig2.class)
public class JavaConfig {
    public JavaConfig() {}
}
