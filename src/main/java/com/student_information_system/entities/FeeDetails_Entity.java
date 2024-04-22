package com.student_information_system.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FeeDetails_Entity {
	@Id
	private Long id;
	private String enrollmentNo;
	private Double feeamount;
	private Date dueDate;
	private String updatedby;
	private Date updatedDate;
}
