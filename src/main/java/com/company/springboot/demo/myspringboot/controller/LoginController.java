package com.company.springboot.demo.myspringboot.controller;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String home(HttpServletRequest request,Model model) {

		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		User user=(User) auth.getPrincipal();
		
		model.addAttribute("username",request.getUserPrincipal().getName());
		System.out.println("000 ::" + request.getUserPrincipal().getName());
		System.out.println("111111 ::" + auth.getPrincipal());
		System.out.println("222 ::" + auth.getName());	
		System.out.println("3333 ::" + auth.getCredentials());
		System.out.println("444 ::" + auth.getAuthorities().getClass());
		System.out.println("55 ::" + auth.getDetails());
		System.out.println("################ ::" );
		System.out.println("the username :: "+user.getUsername());
		System.out.println("the email :: "+user.getEmail());
		System.out.println("the createdDate :: "+user.getCreateDate());
		System.out.println("the created By :: "+user.getCreatedBy());


		
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
