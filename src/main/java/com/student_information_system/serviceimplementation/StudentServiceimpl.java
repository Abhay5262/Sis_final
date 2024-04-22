package com.student_information_system.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_information_system.entities.EducationDetails_Entity;
import com.student_information_system.entities.FeeDetails_Entity;
import com.student_information_system.entities.Student_Entity;
import com.student_information_system.proxies.EducationDetails_Dto;
import com.student_information_system.proxies.FeeDetails_Dto;
import com.student_information_system.proxies.Student_Dto;
import com.student_information_system.repositories.EducationDetails_repo;
import com.student_information_system.repositories.FeeDetails_repo;
import com.student_information_system.repositories.Student_repo;
import com.student_information_system.services.EducationDetails_service;
import com.student_information_system.services.FeeDetails_service;
import com.student_information_system.services.Student_service;
import com.student_information_system.utils.Helper;

@Service
public class StudentServiceimpl implements Student_service,FeeDetails_service,EducationDetails_service{
	
	
	@Autowired
	private Student_repo student_repo;
	
	@Autowired
	private FeeDetails_repo feeDetails_repo;
	
	@Autowired
	private EducationDetails_repo educationDetails_repo;
	
	@Override
	public String registerWithDetails(Student_Dto student) {
		Student_Entity sEntity=Helper.dtotoStudent_Entity(student);
		sEntity.setRole("ROLE_USER");
		student_repo.save(sEntity);
		return "Data Has been Saved";
	}

	@Override
	public String updateUserDetails( Student_Dto student) 
	{
		
		Student_Entity student_Entity = student_repo.findById(student.getEnrollmentNo()).get();
		
		student_Entity.setPassword(student.getPassword());
		student_Entity.setName(student.getName());
		student_Entity.setGender(student.getGender());
		student_Entity.setDob(student.getDob());
		student_Entity.setBranch(student.getBranch());
		student_Entity.setContact(student.getContact());
		student_Entity.setAddress(student.getAddress());
		student_Entity.setCity(student.getCity());
		student_Entity.setPinCode(student.getPinCode());
		student_Entity.setSecurityKey(student.getSecurityKey());
		student_Entity.setRole(student.getRole());
		
		student_repo.save(student_Entity);

		
		return "Data Has Been Updated";
	}

	@Override
	public Student_Dto getUser(String id) {
		Student_Entity byId = student_repo.findById(id).get();
		Student_Dto entitytoStudent_Dto = Helper.entitytoStudent_Dto(byId);
		return entitytoStudent_Dto; 
	}


	@Override
	public FeeDetails_Dto getFeeDetails(String student_enrollmentNo) {
		FeeDetails_Entity byStudent_enrollmentNo = feeDetails_repo.findByEnrollmentNo(student_enrollmentNo);
		
		FeeDetails_Dto entitytoFeeDetails_Dto = Helper.entitytoFeeDetails_Dto(byStudent_enrollmentNo);
		return entitytoFeeDetails_Dto;
	}

	@Override
	public String addEducationDetails(EducationDetails_Dto education) {
		EducationDetails_Entity dtotoEducationDetails_Entity = Helper.dtotoEducationDetails_Entity(education);
		educationDetails_repo.save( dtotoEducationDetails_Entity);
		return "Education Detail Has Been Saved";
	}

	@Override
	public String updateEducationDetails(Long id, EducationDetails_Dto education) {
		EducationDetails_Entity educationDetails_Entity = educationDetails_repo.findById(id).get();
		educationDetails_Entity.setEnrollmentno(education.getEnrollmentno());
		educationDetails_Entity.setEducationtype(education.getEducationtype());
		educationDetails_Entity.setPercentage(education.getPercentage());
		educationDetails_Entity.setQualified(education.getQualified());
		educationDetails_Entity.setUpdatedby(education.getUpdatedby());
		educationDetails_Entity.setUpdatedDate(education.getUpdatedDate());
		
		educationDetails_repo.save(educationDetails_Entity);
		
		return "Education Detail Has Been Updated";
	}

	

	

	

	
}

