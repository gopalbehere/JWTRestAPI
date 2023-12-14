package com.smm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.smm.Config.JwtFilter;

@SpringBootApplication
public class JwtFinalApplication {
	
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean ob= new FilterRegistrationBean();
		ob.setFilter(new JwtFilter());
		ob.addUrlPatterns("/api/*");
		return ob;
	}
	public static void main(String[] args) {
		SpringApplication.run(JwtFinalApplication.class, args);
		System.out.println("prject Started");
	}

}
