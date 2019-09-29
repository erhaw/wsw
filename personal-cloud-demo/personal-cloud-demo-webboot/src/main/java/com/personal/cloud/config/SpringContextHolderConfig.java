package com.personal.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringContextHolderConfig {

	@Bean
	public SpringContextHolder getSpringContextHolder() {
		SpringContextHolder springContextHolder = new SpringContextHolder();
		return springContextHolder;
	}

}
