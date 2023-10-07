package com.company.springboot.demo.myspringboot.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.springboot.demo.myspringboot.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

	Optional<User> findByEmail(String email);
}
