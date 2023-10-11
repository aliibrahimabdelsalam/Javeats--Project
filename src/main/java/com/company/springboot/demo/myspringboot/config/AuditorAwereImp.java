package com.company.springboot.demo.myspringboot.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwereImp implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		return Optional.of("test");
	}

}
