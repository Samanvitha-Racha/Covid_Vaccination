package com.covid.repository;

import javax.validation.constraints.NotNull;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.covid.model.User;

public interface UserRepo extends MongoRepository<User, String>{

	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);

}
