package com.student_information_system.entities;

import java.sql.Date;

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
public class Student_Entity {
		@Id
		private String enrollmentNo;
		private String password;
		private String name;
		private String gender;
		private Date dob;
		private String branch;
		private String contact;
		private String address;
		private String city;
		private Integer pinCode;
		private String securityKey;
		private String role;
		private String email;
	 
}
