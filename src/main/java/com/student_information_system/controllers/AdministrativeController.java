package com.student_information_system.controllers;

import java.util.List;

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

import com.student_information_system.proxies.Administartor_Dto;
import com.student_information_system.proxies.EducationDetails_Dto;
import com.student_information_system.proxies.FeeDetails_Dto;
import com.student_information_system.proxies.Student_Dto;
import com.student_information_system.services.Administartor_service;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdministrativeController {
	
	@Autowired
	private Administartor_service administartor_service;
	
	@PostMapping("/register")	
	public ResponseEntity<String>registerWithDetails(@RequestBody Administartor_Dto administartor_Dto){
		return new ResponseEntity<String>(administartor_service.registerWithDetails(administartor_Dto),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/updateUser")
	public ResponseEntity<String>updateUserDetails(@RequestBody Student_Dto student_Dto){
		return new ResponseEntity<String>(administartor_service.updateUserDetails( student_Dto),HttpStatus.OK);
	}
	
	@PostMapping("/updateAdmin")
	public ResponseEntity<String>updateAdminDetails(@RequestBody Administartor_Dto administartor_Dto){
		System.err.println("ADMIN"+administartor_Dto);
		return new ResponseEntity<String>(administartor_service.updateAdminDetails(administartor_Dto),HttpStatus.OK);
	}
	@PostMapping("/deleteUser/{enrollmentno}")
	public ResponseEntity<String>deleteUser(@PathVariable String enrollmentno){
		return new ResponseEntity<String>(administartor_service.deleteUser(enrollmentno),HttpStatus.OK);
	}
	@GetMapping("/getallUsers")
	public ResponseEntity<List<Student_Dto>> getUsers(){
		return new ResponseEntity<List<Student_Dto>>(administartor_service.getUsers(),HttpStatus.OK);
	}
	@GetMapping("/getUser/{id}")
	public ResponseEntity<Student_Dto>getUser(@PathVariable String id){
		return new ResponseEntity<Student_Dto>(administartor_service.getUser(id),HttpStatus.OK);
	}
	@GetMapping("/getAdmin/{id}")
	public ResponseEntity<Administartor_Dto>getAdmin(@PathVariable String id){
		return new ResponseEntity<>(administartor_service.getAdmin(id),HttpStatus.ACCEPTED);
	}
	@PostMapping("/addFeeDetails")
	public ResponseEntity<String>addFeeDetails(@RequestBody FeeDetails_Dto feeDetails){
		return new ResponseEntity<String>(administartor_service.addFeeDetails(feeDetails),HttpStatus.ACCEPTED);
	}
	@GetMapping("/getFeeDetails/{id}")
	public ResponseEntity<FeeDetails_Dto>getFeeDetails(@PathVariable String id){
		return new ResponseEntity<>(administartor_service.getFeeDetails(id),HttpStatus.OK);
	}
	
	@GetMapping("/GetEducationDetails/{id}")
	public ResponseEntity<EducationDetails_Dto>GetEducationDetails(@PathVariable Long id){
		return new ResponseEntity<EducationDetails_Dto>(administartor_service.GetEducationDetails(id),HttpStatus.ACCEPTED);
	}
}
