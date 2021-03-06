package com.techmaze.techmaze.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@EnableConfigurationProperties
public class BuilderPatternConfig {
	
	@Value("${findNationality_url}")
	private String nationalityUrl;
	
	@Bean
	public String nationalityUrl() {
		return this.nationalityUrl;
	}

}
