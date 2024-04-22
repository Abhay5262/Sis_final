package com.student_information_system.services;

import org.springframework.stereotype.Service;

import com.student_information_system.proxies.EducationDetails_Dto;

@Service
public interface EducationDetails_service {
	public String addEducationDetails(EducationDetails_Dto education);
	public String updateEducationDetails(Long id, EducationDetails_Dto education);
}
