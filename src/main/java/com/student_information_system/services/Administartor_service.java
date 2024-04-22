package com.student_information_system.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student_information_system.proxies.Administartor_Dto;
import com.student_information_system.proxies.EducationDetails_Dto;
import com.student_information_system.proxies.FeeDetails_Dto;
import com.student_information_system.proxies.Student_Dto;

@Service
public interface Administartor_service {
	public String registerWithDetails( Administartor_Dto administartor_Dto);
	public String updateUserDetails( Student_Dto student_Dto);
	public String updateAdminDetails(Administartor_Dto administartor_Dto);
	public String deleteUser(String enrollmentno);
	public List<Student_Dto> getUsers();
	public Student_Dto getUser(String id);
	public Administartor_Dto getAdmin(String id);
	public String addFeeDetails(FeeDetails_Dto feeDetails);
	public FeeDetails_Dto getFeeDetails(String student_enrollmentNo);
	public  EducationDetails_Dto GetEducationDetails(Long id);

	
}
