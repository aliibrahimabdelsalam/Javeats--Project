package com.company.springboot.demo.myspringboot.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends User implements UserDetails {

	public CustomUserDetails(User user){
		super(user);
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
	final List<GrantedAuthority> authorityList=new ArrayList<GrantedAuthority>();
	super.getRoles().forEach(role->{
		authorityList.add(new SimpleGrantedAuthority(role.getName()));
	});
	
		return authorityList;
	}

	public String getUsername() {
		
		return super.getUsername();
	}
	public String getPassword() {
		
		return super.getPassword();
	}
	public boolean isAccountNonExpired() {
		
		return true;
	}

	public boolean isAccountNonLocked() {
		
		return true;
	}

	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	public boolean isEnabled() {
		
		return true;
	}

}
