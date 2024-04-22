package com.student_information_system.proxies;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Administartor_Dto {
	
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
