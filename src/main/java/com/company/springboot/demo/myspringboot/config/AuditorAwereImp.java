package com.company.springboot.demo.myspringboot.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.company.springboot.demo.myspringboot.entity.User;

public class AuditorAwereImp implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		User user=(User) auth.getPrincipal();
		return Optional.of(user.getUsername());
	}

}
