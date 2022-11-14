package com.covid.model;

import java.util.Date;


import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "User")
public class User {
	
	@Id
	@NotNull
	private String id;
	
	@NotNull
    private String username;

    @NotNull
    private String password;

    
    @NotNull
    private String email;
    
    @NotNull
    private String firstName;
    
    @NotNull
    private String lastName;
    
    @NotNull
    private String contactNumber;

}
