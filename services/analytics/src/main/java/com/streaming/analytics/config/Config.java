package com.streaming.analytics.config;

import com.streaming.analytics.shared.Auditable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Config {

  @Bean
  public Auditable myAuditorProvider() {
    return new Auditable();
  }
}
