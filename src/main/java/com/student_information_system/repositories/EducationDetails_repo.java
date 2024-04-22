package com.student_information_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student_information_system.entities.EducationDetails_Entity;
@Repository
public interface EducationDetails_repo extends JpaRepository<EducationDetails_Entity, Long> {

}
