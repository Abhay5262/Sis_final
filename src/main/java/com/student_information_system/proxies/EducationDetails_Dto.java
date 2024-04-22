package com.student_information_system.proxies;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EducationDetails_Dto {
	
	private Long id;
	private String enrollmentno;
	private String educationtype;
	private String percentage;
	private Boolean qualified;
	private String updatedby;
	private Date updatedDate;
}
