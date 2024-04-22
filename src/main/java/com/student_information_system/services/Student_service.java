package com.student_information_system.services;

import org.springframework.stereotype.Service;

import com.student_information_system.proxies.Student_Dto;

@Service
public interface Student_service {
	public String registerWithDetails (Student_Dto student);
	public String updateUserDetails( Student_Dto student);
	public Student_Dto getUser(String id);
}
