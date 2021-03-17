package com.marvelheroes.demoMarvel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.marvelheroes.demoMarvel.mapper.IMapper;
import com.marvelheroes.demoMarvel.mapper.SuperHeroMapper;

/**
 * The Class DemoMarvelApplication.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableCaching
public class DemoMarvelApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoMarvelApplication.class, args);
	}
	
}
