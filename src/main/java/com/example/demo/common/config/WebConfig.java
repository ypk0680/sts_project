package com.example.demo.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.common.interceptor.LoginCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		// LoginCheckInterceptor를 어디에 적용 할 것이고, 어디에 적용하지 않을 건지..
		registry.addInterceptor(new LoginCheckInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/","/main", "/member/login*", "/member/joinMember*", "/css/**", "/js/**", "/image/**");
		// 우선순위는 예외처리가 높다. 
	}	
}
