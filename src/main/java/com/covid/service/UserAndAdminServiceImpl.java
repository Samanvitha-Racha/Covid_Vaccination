package com.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.exception.InvalidUsernameOrPasswordException;
import com.covid.exception.UserNameAlreadyExistsException;
import com.covid.model.Admin;
import com.covid.model.Login;
import com.covid.model.User;
import com.covid.model.UserResponse;
import com.covid.repository.AdminRepo;
import com.covid.repository.LoginRepo;
import com.covid.repository.UserRepo;

@Service
public class UserAndAdminServiceImpl implements UserAndAdminService{
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	LoginRepo loginRepo;
	
	@Override
	public User signUp(User user) throws UserNameAlreadyExistsException
	{
		
	      if(userRepo.findByUsername(user.getUsername()) != null) {
	    	  throw new UserNameAlreadyExistsException("username already exists");
	      }
	      User savedUser = userRepo.save(user);
	      return savedUser;
		
	}
	
	@Override
    public User login(String username, String password) {
    	User user = userRepo.findByUsernameAndPassword(username,password);
    	return user;
    			
    	}
	

	
	@Override
	public Admin searchForVaccinationCentre(String vaccinationCentre){
		Admin search = adminRepo.findByVaccinationCentre(vaccinationCentre);
		return search;
	}
	
	@Override
	public Login loginAdmin(String username, String password) {
		Login user = loginRepo.findByUsernameAndPassword(username, password);
		return user;
		}
	
	@Override
	public Admin addVaccinationCentre (Admin admin) {
		return adminRepo.save(admin);
	}
	
	@Override
	public List<Admin> getAllVaccinationCentres() {
        List<Admin> admin = adminRepo.findAll();
        return admin;
		
	}
	
//	@Override
//	public List<Admin> getDosagesByVaccinationCentre(String vaccinationCentre){
//		List<Admin> alldosages = adminRepo.findByCentre(vaccinationCentre);
//    	
//    		return alldosages;
//	}
	
	@Override
	public String deleteVaccinationCentre(String vaccinationCentre) {
		Admin deleteVaccinationCentre = adminRepo.findByVaccinationCentre(vaccinationCentre);
		adminRepo.delete(deleteVaccinationCentre);
        return "Vaccination Centre deleted successfully";
	}




}
