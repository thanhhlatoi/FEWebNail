package com.example.API.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        final Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dhttupoeh");
        config.put("api_key", "827463841799233");
        config.put("api_secret", "cLGS-nop4fTKyxSRmRxW_vwd0As");
        return new Cloudinary(config);
    }
}
