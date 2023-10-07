package com.company.springboot.demo.myspringboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.springboot.demo.myspringboot.entity.CustomUserDetails;
import com.company.springboot.demo.myspringboot.entity.User;

@Service	
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=userService.findByEmail(email).get();
		if(user.equals(null)) throw new UsernameNotFoundException("the email you enter is wrong");
		return new CustomUserDetails(user);
	}

}
