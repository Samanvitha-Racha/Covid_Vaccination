package com.covid.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.covid.exception.UserNameAlreadyExistsException;
import com.covid.model.Admin;
import com.covid.model.Login;
import com.covid.model.User;
import com.covid.service.UserAndAdminService;


@RestController
@RequestMapping("/covidvaccination")
public class UserAndAdminController {
	
	@Autowired
	UserAndAdminService userAndAdminService;
	
	/*
	 * REGISTER USER
	 */
	@PostMapping("/register")
    public ResponseEntity<User> signUp(@RequestBody User user) throws UserNameAlreadyExistsException {
        return new ResponseEntity<User>(userAndAdminService.signUp(user),HttpStatus.CREATED);
        }

    /*
     * LOGIN USER
     */
    @PostMapping("/user/login")
    public ResponseEntity<User> login(String username,String  password){
   	 User login = userAndAdminService.login(username,password);
   	 return new ResponseEntity<User>(login,HttpStatus.OK);
    }
    
    /*
     * SEARCH FOR VACCINATION CENTRE
     */
    @GetMapping("/searchVaccinationCentre")
    public ResponseEntity<Admin> searchByvaccinationCentre(@PathVariable String vaccinationCentre)
    {
       
        ResponseEntity<Admin> search = new ResponseEntity<Admin>(HttpStatus.OK);
        return search;
    }
    
    /*
     * LOGOUT
     */
    @PostMapping("/user/logout")
	 
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
	 return "logged out successfully";
    }
    
    

    /*
     * ADMIN LOGIN
     */
	 @PostMapping("/admin/login")
    public ResponseEntity<Login> loginAdmin(String username,String  password){
   	 Login login = userAndAdminService.loginAdmin(username,password);
   	 return new ResponseEntity<Login>(login,HttpStatus.OK);
    }
	 
	 /*
	  * ADD VACCINATION CENTRE
	  */
	 @PostMapping("/add")
	    public ResponseEntity<Admin> addVaccinationCentre(@RequestBody Admin addVaccinationCentre) 
	    {
		 	addVaccinationCentre = userAndAdminService.addVaccinationCentre(addVaccinationCentre);
	        ResponseEntity<Admin> admin = new ResponseEntity<Admin>(addVaccinationCentre,HttpStatus.OK);
	        return admin;
	    }
	 
	 /*
	  * GET ALL VACCINATION CENTRES
	  */
	 @GetMapping("/all")
	    public ResponseEntity<List<Admin>> getAllCentres()
	    {
	        
	       ResponseEntity<List<Admin>> getCentres = new ResponseEntity<List<Admin>>(userAndAdminService.getAllVaccinationCentres(),HttpStatus.OK);
	        return getCentres;
	    }
	 
//	 @GetMapping("/{vaccinationCentre}")
//	    public ResponseEntity<List<Admin>> getDosagesByVaccinationCentre(@PathVariable String vaccinationCentre) 
//	    {
//	        ResponseEntity<List<Admin>> response = new ResponseEntity<List<Admin>>(userAndAdminService.getDosagesByVaccinationCentre(vaccinationCentre),HttpStatus.OK);
//	        return response;
//	    }
	 
	 /*
	  * DELETE VACCINATION CENTRE
	  */
	 @DeleteMapping("/delete/{vaccinationCentre}")
	    public ResponseEntity<Admin> deleteTweetById(@PathVariable String vaccinationCentre)
	    {
		 userAndAdminService.deleteVaccinationCentre(vaccinationCentre);
	        return new ResponseEntity<Admin>(HttpStatus.OK);
	    }
	

}
