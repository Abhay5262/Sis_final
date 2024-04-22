package com.student_information_system.utils;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student_information_system.entities.Administartor_Entity;
import com.student_information_system.entities.EducationDetails_Entity;
import com.student_information_system.entities.FeeDetails_Entity;
import com.student_information_system.entities.Student_Entity;
import com.student_information_system.proxies.Administartor_Dto;
import com.student_information_system.proxies.EducationDetails_Dto;
import com.student_information_system.proxies.FeeDetails_Dto;
import com.student_information_system.proxies.Student_Dto;

@Component
public class Helper {
	
	

//Converstion of Administartor Class//
	public static Administartor_Dto entitytoAdministartor_Dto(Administartor_Entity ae) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(ae, Administartor_Dto.class);
	}
	
	public static Administartor_Entity dtotoAdministartor_Entity(Administartor_Dto ad) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(ad, Administartor_Entity.class);
	}
	// Converstion Of Education class//
	public static EducationDetails_Dto entitytoEducationDetails_Dto(EducationDetails_Entity ee) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(ee, EducationDetails_Dto.class);
	}
	
	public static EducationDetails_Entity dtotoEducationDetails_Entity(EducationDetails_Dto ed) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(ed, EducationDetails_Entity.class);
	}
	
	//Converstion of Fee Datial class//
	
	public static FeeDetails_Dto entitytoFeeDetails_Dto(FeeDetails_Entity fe) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(fe, FeeDetails_Dto.class);
	}
	
	public static FeeDetails_Entity dtotoFeeDetails_Entity(FeeDetails_Dto fd) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(fd, FeeDetails_Entity.class);
	}
	
	//Converstion Of Student Class//
	
	public static Student_Dto entitytoStudent_Dto(Student_Entity se) {
		ObjectMapper mapper =new ObjectMapper();
		return mapper.convertValue(se, Student_Dto.class);
	}
	
	public static Student_Entity dtotoStudent_Entity(Student_Dto sd) {
		ObjectMapper mapper =new ObjectMapper();
		return  mapper.convertValue(sd, Student_Entity.class);
	}
	
}
