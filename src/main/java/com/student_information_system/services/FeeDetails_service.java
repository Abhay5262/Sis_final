package com.student_information_system.services;

import org.springframework.stereotype.Service;

import com.student_information_system.proxies.FeeDetails_Dto;
@Service
public interface FeeDetails_service {


	public FeeDetails_Dto getFeeDetails(String student_enrollmentNo);
}
