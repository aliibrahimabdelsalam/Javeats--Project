package com.company.springboot.demo.myspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.springboot.demo.myspringboot.entity.Role;
import com.company.springboot.demo.myspringboot.entity.User;
import com.company.springboot.demo.myspringboot.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleService roleService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public User save(User user){
		List<Role> roles=new ArrayList<Role>();
		roles.add(roleService.findById(2l).get());
		user.setRoles(roles);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);	
	}
	
	public Optional<User> findByEmail(String email){
		return userRepo.findByEmail(email);	
	}
	public Optional<User> findById(Long id){
		return userRepo.findById(id);	
	}
	public List<User> findAll(){
		return (List<User>) userRepo.findAll();	
	}
	public User update(User entity) throws Exception{
		if(entity==null) {
			throw new Exception("not found the user by name ::"+ entity.getUsername());
		}
		
		return userRepo.save(entity);	
	}
	public void deleteById(Long id){
		 userRepo.deleteById(id);
	}
}
