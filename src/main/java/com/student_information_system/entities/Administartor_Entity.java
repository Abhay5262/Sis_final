package com.student_information_system.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Administartor_Entity {
	@Id
	private String id;
	private String password;
	private String name;
	private String gender;
	private String contact;
	private String address;
	private String city;
	private String pincode;
	private String securitykey;
	private String role;
	private String email;
	public 	Date    dob;
	
	
}
