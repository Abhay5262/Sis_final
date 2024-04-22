package com.student_information_system.proxies;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student_Dto {
	
	private String enrollmentNo;
	private String password;
	private String name;
	private String gender;
	private Date dob;
	private String branch;
	private String contact;
	private String address;
	private String city;
	private Integer pinCode;
	private String securityKey;
	private String role;
	private String email;
}
