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
public class FeeDetails_Dto {
	
	private Long id;
	private String enrollmentNo;
	private Double feeamount;
	private Date dueDate;
	private String updatedby;
	private Date updatedDate;
}
