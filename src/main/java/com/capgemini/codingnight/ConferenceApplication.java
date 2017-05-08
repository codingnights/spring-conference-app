package com.capgemini.codingnight;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EnableAutoConfiguration
public class ConferenceApplication {

//	@Bean
//	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Singleton singleton() {
		return new Singleton();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConferenceApplication.class, args);
	}
}
