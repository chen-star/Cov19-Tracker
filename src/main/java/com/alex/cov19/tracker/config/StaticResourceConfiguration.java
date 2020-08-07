package com.alex.cov19.tracker.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Alex CHEN
 * @version 1.0
 * @since 2020-08-05 22:13
 */
@Configuration
@EnableWebMvc
@ComponentScan
public class StaticResourceConfiguration extends WebMvcAutoConfiguration {
}