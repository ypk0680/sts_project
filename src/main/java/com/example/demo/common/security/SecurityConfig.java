package com.example.demo.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //설정 용 클래스
@EnableWebSecurity // 웹 보안에 대한 클래스
public class SecurityConfig {
   
   @Bean
   PasswordEncoder passwordencoder() {
      return new BCryptPasswordEncoder();
   }
   
   @Bean
   SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	   http
	   	.csrf(csrf -> csrf.disable()) //csrf 웹사이트 공격(위조 방지)
	   	.authorizeHttpRequests(auth -> auth // auth 권한
	   			.requestMatchers("/**").permitAll() // member, board, common 권한 허용
	   			.anyRequest().authenticated()  // 나머지 애들은 권한을 확인하겠다!!
	    );
	return http.build();
   }
}
