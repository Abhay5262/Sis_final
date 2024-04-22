package com.student_information_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student_information_system.proxies.EducationDetails_Dto;
import com.student_information_system.proxies.FeeDetails_Dto;
import com.student_information_system.proxies.Student_Dto;
import com.student_information_system.services.EducationDetails_service;
import com.student_information_system.services.FeeDetails_service;
import com.student_information_system.services.Student_service;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class Usercontroller {
	@Autowired
	private Student_service student_service;
	
	@Autowired
	private FeeDetails_service feeDetails_service;
	
	@Autowired
	private EducationDetails_service educationDetails_service;
	
	@PostMapping("/register")
	public ResponseEntity<String>registerWithDetails(@RequestBody Student_Dto student){
		
		return new ResponseEntity<String>(student_service.registerWithDetails(student),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/updateUser/{id}")
	public ResponseEntity<String>updateUserDetails( @RequestBody Student_Dto student){
		return new ResponseEntity<>(student_service.updateUserDetails(student),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<Student_Dto>getUser(@PathVariable String id){
		return new ResponseEntity<Student_Dto>(student_service.getUser(id),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getFeeDetails/{student_enrollmentNo}")
	public ResponseEntity<FeeDetails_Dto>getFeeDetails(@PathVariable String student_enrollmentNo){
		return new ResponseEntity<FeeDetails_Dto>(feeDetails_service.getFeeDetails(student_enrollmentNo),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/addEducationDetails")
	public ResponseEntity<String>addEducationDetails(@RequestBody EducationDetails_Dto education){
		return new ResponseEntity<String>(educationDetails_service.addEducationDetails(education),HttpStatus.OK);
	}
	
	@PostMapping("/updateEducationDetails/{id}")
	public ResponseEntity<String>updateEducationDetails(@PathVariable Long id,@RequestBody EducationDetails_Dto education){
		return null;
	}
}
