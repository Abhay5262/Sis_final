package com.student_information_system.serviceimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.student_information_system.entities.Administartor_Entity;
import com.student_information_system.entities.EducationDetails_Entity;
import com.student_information_system.entities.FeeDetails_Entity;
import com.student_information_system.entities.Student_Entity;
import com.student_information_system.proxies.Administartor_Dto;
import com.student_information_system.proxies.EducationDetails_Dto;
import com.student_information_system.proxies.FeeDetails_Dto;
import com.student_information_system.proxies.Student_Dto;
import com.student_information_system.repositories.Administartor_repo;
import com.student_information_system.repositories.EducationDetails_repo;
import com.student_information_system.repositories.FeeDetails_repo;
import com.student_information_system.repositories.Student_repo;
import com.student_information_system.services.Administartor_service;
import com.student_information_system.utils.Helper;

@Component
@Primary
public class Administrartor_serviceimpl extends StudentServiceimpl implements Administartor_service {
	
	
	
	@Autowired
	private Administartor_repo administartor_repo;
	
	@Autowired
	private Student_repo student_repo;
	
	@Autowired
	private FeeDetails_repo feeDetails_repo;
	
	@Autowired
	private EducationDetails_repo educationDetails_repo;
	
	 @Autowired
	 private JavaMailSender javaMailSender;
	
	 
	 
	@Override
	public String registerWithDetails(Administartor_Dto administartor_Dto) {
		Administartor_Entity dtotoAdministartor_Entity = Helper.dtotoAdministartor_Entity(administartor_Dto);
		administartor_repo.save(dtotoAdministartor_Entity);
		return "Data Has Been Saved";
	}

	@Override
	public String updateAdminDetails(Administartor_Dto administartor_Dto) {
		Administartor_Entity administartor_Entity = administartor_repo.findById(administartor_Dto.getId()).get();
//		Administartor_Entity administartor_Entity = administartor_repo.findByEmail(administartor_Dto.getEmail()).get();
		administartor_Entity.setName(administartor_Dto.getName());
		administartor_Entity.setGender(administartor_Dto.getGender());
		administartor_Entity.setContact(administartor_Dto.getContact());
		administartor_Entity.setAddress(administartor_Dto.getAddress());
		administartor_Entity.setPassword(administartor_Dto.getPassword());
		administartor_Entity.setSecuritykey(administartor_Dto.getSecuritykey());
		administartor_Entity.setRole(administartor_Dto.getRole());
		administartor_repo.save(administartor_Entity);
		return "Dats Has Been Upated";
	}

	@Override
	public String deleteUser(String enrollmentno) {
			student_repo.deleteById(enrollmentno);
		return "Student Has Been Deleted";
	}

	@Override
	public List<Student_Dto> getUsers() {
		
		List<Student_Entity> e=student_repo.findAll();
		List<Student_Dto> dto=new ArrayList<>();
		
		for (Student_Entity se : e) {
			Student_Dto dto1=(Student_Dto) Helper.entitytoStudent_Dto(se);
			dto.add(dto1);
		}
	return dto;	
	}

	@Override
	public String addFeeDetails(FeeDetails_Dto feeDetails) {
		FeeDetails_Entity FeeDetails_Entity = Helper.dtotoFeeDetails_Entity(feeDetails);
		feeDetails_repo.save(FeeDetails_Entity);
		return "Fee Detail Has Been Added";
	}

	@Override
	public EducationDetails_Dto GetEducationDetails(Long id) {
		EducationDetails_Entity educationDetails_Entity = educationDetails_repo.findById(id).get();
		EducationDetails_Dto entitytoEducationDetails_Dto = Helper.entitytoEducationDetails_Dto(educationDetails_Entity);
		return entitytoEducationDetails_Dto;
	}

	@Override
	public Administartor_Dto getAdmin(String id) {
		Administartor_Entity administartor_Entity = administartor_repo.findById(id).get();
		Administartor_Dto entitytoAdministartor_Dto = Helper.entitytoAdministartor_Dto(administartor_Entity);
		return entitytoAdministartor_Dto;
	}

}
