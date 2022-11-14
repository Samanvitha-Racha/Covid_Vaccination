package com.covid.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.covid.model.Admin;
import com.covid.model.Login;

public interface AdminRepo extends MongoRepository<Admin, String>{
	
	
	Admin findByVaccinationCentre(String vaccinationCentre);
	//List<Admin> findByCentre(String vaccinationCentre);

}
