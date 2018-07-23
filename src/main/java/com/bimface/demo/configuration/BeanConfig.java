package com.bimface.demo.configuration;

import com.bimface.sdk.BimfaceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Value("${app.key}")
    private String appKey;
    @Value("${app.secret}")
    private String appSecret;

    @Bean
    public BimfaceClient bimfaceClient() {
        return new BimfaceClient(appKey, appSecret);
    }

}
