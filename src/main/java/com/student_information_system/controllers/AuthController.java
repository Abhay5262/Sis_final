package com.student_information_system.controllers;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student_information_system.entities.Otp;
import com.student_information_system.repositories.Administartor_repo;
import com.student_information_system.repositories.Otp_repo;
import com.student_information_system.repositories.Student_repo;
import com.student_information_system.reqrep.Request;
import com.student_information_system.reqrep.Response;
import com.student_information_system.serviceimplementation.Email_serviceimpl;
import com.student_information_system.services.Auth_service;
import com.student_information_system.userdetail.ProjectUserDetail;
import com.student_information_system.utils.Jwtutil;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private ProjectUserDetail projectUserDetails;
	
	@Autowired
	private Jwtutil jwtUtils;
	
	@Autowired
	private Email_serviceimpl email_serviceimpl;
	
	@Autowired
	private Auth_service auth_service;
	
	@Autowired
	private Otp_repo o_repo;
	
	@Autowired
	private Administartor_repo administartor_repo;
	
	@Autowired
	private Student_repo student_repo;
 
	
	@PostMapping("/login")
	public ResponseEntity<Response> loginWithCredentials(@RequestBody Request loginRequest)
	{
		try {
			projectUserDetails.setRole(loginRequest.getRole());
			System.err.println(loginRequest);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		UserDetails userDetails = projectUserDetails.loadUserByUsername(loginRequest.getUsername());
		
		String token = jwtUtils.generateToken(userDetails);
		
		return new ResponseEntity<Response> (new Response(token),HttpStatus.OK);
	}
	
	
	@PostMapping("/validate")
	public ResponseEntity<String> ValidateToken()
	{
		return new ResponseEntity<String> ("JWT Token Working",HttpStatus.ACCEPTED);
	}
	
	Random random=new Random();
	
	@PostMapping("/forgot/{email}/{dob}")
	public ResponseEntity<String> sendMessage(@PathVariable("email") String email,@PathVariable("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob)
	{
		return new ResponseEntity<String>(auth_service.sendMessage(email, dob), HttpStatus.OK);
	}
	@PostMapping("/verify/{email}/{otp}")
	public ResponseEntity<String> verify(@PathVariable("email") String email,@PathVariable("otp") Integer otp) {
		return new ResponseEntity<String>(auth_service.verify(email, otp), HttpStatus.OK);
	}
	@PostMapping("/getData/{email}")
	public ResponseEntity<Object> getEmailData(@PathVariable("email") String  email)
	{
		return new ResponseEntity<>(auth_service.getEmailData(email), HttpStatus.OK);
	}
	@PostMapping("/tempurl/{email}/{dob}")
	public ResponseEntity<String> temlink(@PathVariable("email") String email,@PathVariable("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob){
		return new ResponseEntity<String>(auth_service.sendurl(email, dob), HttpStatus.OK);
	}
}
