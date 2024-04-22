package com.student_information_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student_information_system.entities.FeeDetails_Entity;

@Repository
public interface FeeDetails_repo extends JpaRepository<FeeDetails_Entity, Long> {

	FeeDetails_Entity findByEnrollmentNo(String enrollmentNo);

}
