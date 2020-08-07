package com.alex.cov19.tracker.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Alex CHEN
 * @version 1.0
 * @since 2020-08-05 19:23
 */
@PropertySource("classpath:/application.properties")
@Configuration
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws Exception {
        PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        placeholderConfigurer.setNullValue("@null");
        return placeholderConfigurer;
    }


    @Bean
    MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName){
        return registry -> registry.config().commonTags("application", applicationName);
    }

}
