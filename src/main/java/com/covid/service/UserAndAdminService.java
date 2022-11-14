package com.covid.service;

import java.util.List;

import com.covid.exception.InvalidUsernameOrPasswordException;
import com.covid.exception.UserNameAlreadyExistsException;
import com.covid.model.Admin;
import com.covid.model.Login;
import com.covid.model.User;
import com.covid.model.UserResponse;

public interface UserAndAdminService {
	
	User signUp(User user) throws UserNameAlreadyExistsException;
	User login(String username, String password);
	Admin searchForVaccinationCentre(String vaccinationCentre);

	
	Login loginAdmin(String username, String password);
	Admin addVaccinationCentre (Admin admin);
	List<Admin> getAllVaccinationCentres();
	//List<Admin> getDosagesByVaccinationCentre(String vaccinationCentre);
	String deleteVaccinationCentre(String vaccinationCentre);

}
