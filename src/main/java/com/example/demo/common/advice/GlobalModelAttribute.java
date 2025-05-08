package com.example.demo.common.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalModelAttribute {
	
	@ModelAttribute("loginId")  //loginId를 사용하게되면 전체적으로 session에 적용
	public String loginId(HttpSession session) {
		return (String) session.getAttribute("loginId");
				
	}
}
