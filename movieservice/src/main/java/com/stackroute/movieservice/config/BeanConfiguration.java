package com.stackroute.movieservice.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stackroute.movieservice.filter.JwtFilter;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		FilterRegistrationBean registrationBean=new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/v1/movieservice/user/*");
		return registrationBean;
		
	}

}
