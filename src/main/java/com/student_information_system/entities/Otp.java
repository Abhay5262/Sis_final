package com.student_information_system.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Otp {
	@Id
	private String email;
	private  Integer otp;
	private  LocalDateTime expirationtime;
	private String url;
}
