package com.company.springboot.demo.myspringboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.company.springboot.demo.myspringboot.entity.User;
import com.company.springboot.demo.myspringboot.service.UserService;

@Controller
public class LoginController {

	
	@Autowired
	private UserService userService;
	@GetMapping("/")
	public String home() {
		
		return "index";
	}
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@PostMapping("/register")
	public String registerPost(@ModelAttribute ("User")User user,HttpServletRequest request) throws ServletException {

		String password=user.getPassword();
		userService.save(user);
		request.login(user.getEmail(), password);
		
		return "redirect:/";
	}
}
