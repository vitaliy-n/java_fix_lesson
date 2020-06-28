package com.cheba00.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.cheba00.app")
public class AppConfig {
    @Bean
    public MessageRender messageRender () {
        return new MessageRenderErrorImpl(message());

    }
    @Bean
    public Message message() {
        return new HelloMessage("hello");
    }
}

