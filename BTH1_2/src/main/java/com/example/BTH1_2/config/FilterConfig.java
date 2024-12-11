package com.example.BTH1_2.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.BTH1_2.filter.JwtFilter;
import com.example.BTH1_2.jwt.JwtUtil;

@Component
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter(JwtUtil jwtUtil) {
		FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new JwtFilter(jwtUtil));

		registrationBean.addUrlPatterns("/auth/*");

		return registrationBean;
	}
}
