package com.company.springboot.demo.myspringboot.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.company.springboot.demo.myspringboot.entity.Role;
import com.company.springboot.demo.myspringboot.entity.User;
import com.company.springboot.demo.myspringboot.service.RoleService;
import com.company.springboot.demo.myspringboot.service.UserService;

@Component
public class OAuthConfig implements AuthenticationSuccessHandler{
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		OAuth2AuthenticationToken token=(OAuth2AuthenticationToken) authentication;
		String email=token.getPrincipal().getAttributes().get("email").toString();
		if(userService.findByEmail(email)==null) {
			User user=new User();
			user.setEmail(email);
			String firstName=token.getPrincipal().getAttributes().get("given_name").toString();
			String lastName=token.getPrincipal().getAttributes().get("family_name").toString();
			user.setUsername(firstName+lastName);
			List<Role> roles=new ArrayList<Role>();
			roles.add(roleService.findById(2l).get());
			user.setRoles(roles);
			userService.save(user);
		}
		redirectStrategy.sendRedirect(request,response,"/");
	}

}
