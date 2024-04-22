package com.student_information_system.services;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public interface Auth_service {

	boolean authenticateData(String email, Date dob);
	public String sendMessage(String email,Date dob);
	public String verify(String email,Integer otp);
	public Object getEmailData(String  email);
	public String sendurl(String email,Date dob);

}
