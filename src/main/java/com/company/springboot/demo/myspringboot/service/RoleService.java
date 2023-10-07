package com.company.springboot.demo.myspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.springboot.demo.myspringboot.entity.Role;
import com.company.springboot.demo.myspringboot.repository.RoleRepository;

@Service	
public class RoleService {
	@Autowired
	private RoleRepository RoleRepo;
	
	public Role save(Role Role){
		return RoleRepo.save(Role);	
	}
	
	public Optional<Role> findById(Long id){
		return RoleRepo.findById(id);	
	}
	public List<Role> findAll(){
		return (List<Role>) RoleRepo.findAll();	
	}
	
	public void deleteById(Long id){
		 RoleRepo.deleteById(id);
	}
}
