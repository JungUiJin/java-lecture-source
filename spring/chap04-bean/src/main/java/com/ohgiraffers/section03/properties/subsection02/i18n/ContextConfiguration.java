package com.ohgiraffers.section03.properties.subsection02.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ContextConfiguration {
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
