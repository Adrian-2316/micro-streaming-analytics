package com.streaming.analytics.analytics.config;

import com.streaming.analytics.analytics.content.shared.Auditable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Config {

    @Bean
    public Auditable myAuditorProvider() {
        return new Auditable();
    }
}