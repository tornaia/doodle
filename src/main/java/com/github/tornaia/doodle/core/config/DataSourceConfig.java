package com.github.tornaia.doodle.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.github.tornaia.doodle")
@Configuration
public class DataSourceConfig {
}
