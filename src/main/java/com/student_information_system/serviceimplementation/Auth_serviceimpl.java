package com.student_information_system.serviceimplementation;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student_information_system.entities.Otp;
import com.student_information_system.repositories.Administartor_repo;
import com.student_information_system.repositories.Otp_repo;
import com.student_information_system.repositories.Student_repo;
import com.student_information_system.services.Auth_service;

@Component
public class Auth_serviceimpl implements Auth_service {

	@Autowired
	Administartor_repo adminRepo;
	
	@Autowired
	Student_repo studentRepo;
	
	@Autowired
	Otp_repo o_repo;
	
	@Autowired
	Email_serviceimpl email_serviceimpl;
	
	@Override
	public boolean authenticateData(String email, Date dob) {
		
		if(!adminRepo.findEmailId(email).getEmail().isEmpty())
		{
			if(dob.equals(adminRepo.findEmailId(email).getDob()))
			{
				return true;
			}
			else {
				return false;
			}
		}
		return false;
		
}
	@Override
	public String sendMessage(String email, Date dob) {
		System.err.println(dob);
		boolean authenticateData =authenticateData(email, dob);
		
		if(authenticateData)
		{
			Random random=new Random();
			System.err.println(authenticateData);
			int randomotp=random.nextInt(999999);
			
			String to="joshiabhay5262@gmail.com";
			
			String subject="Email Verification";
			
			String message="Your Otp is "+randomotp;
			
			
			email_serviceimpl.Sendemail(to, subject, message);
			 LocalDateTime expirationTime = LocalDateTime.now();
			Otp otp=new Otp();
			otp.setEmail(email);
			otp.setOtp(randomotp);
			otp.setExpirationtime(expirationTime);
			
			
			o_repo.save(otp);
			return "email sent";
			

		}
		else {
			return "Bad credential";
		}
	}
	@Override
	public String verify(String email, Integer otp) {
		Integer otp2 = o_repo.findById(email).get().getOtp();
		
		if(otp2.equals(otp))
		{
			int second = LocalDateTime.now().getSecond();
			int second2 = o_repo.findById(email).get().getExpirationtime().getSecond();
			if (second - second2>30 || second - second2 <0) {
				return "Otp expired regnrate otp ";
			}
			return "Otp verify";
		}
		return "Enter Valid Otp";	
	}
	@Override
	public Object getEmailData(String email) {
		System.err.println(email);
		
		if(!adminRepo.findEmailId(email).getEmail().isBlank())
		{
			return adminRepo.findEmailId(email);
		}
		
		return null;
		}
	
	public String sendurl(String email,Date dob) {
	boolean authenticateData =authenticateData(email, dob);
		
		if(authenticateData)
		{
		
			String uuidString = UUID.randomUUID().toString();
			
			String url="http://localhost:4200/updatepassword/"+email+"?"+uuidString;
		
			String to="joshiabhay5262@gmail.com";
			
			String subject="Email Verification";
			
			String message="Your temp url is "+url;
			
			
			email_serviceimpl.Sendemail(to, subject, message);
		
			Otp otp=new Otp();
			otp.setEmail(email);
			otp.setUrl(url);
			System.err.println(url);
			
			o_repo.save(otp);
			return "email sent";
			

		}
		else {
			return "Bad credential";
		}
	}
	}
	
	
