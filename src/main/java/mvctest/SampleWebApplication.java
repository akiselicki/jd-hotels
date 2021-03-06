package mvctest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@PropertySource("classpath:application.properties")
@Configuration
@EnableJpaRepositories
@EnableAutoConfiguration
@ComponentScan
public class SampleWebApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SampleWebApplication.class, args);
	}
}
