package com.covid.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.covid.model.Admin;
import com.covid.model.Login;

public interface LoginRepo extends MongoRepository<Login, String>{
	
	Login findByUsernameAndPassword(String username,String password);

}
