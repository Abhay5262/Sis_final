package com.student_information_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student_information_system.entities.Otp;
@Repository
public interface Otp_repo extends JpaRepository<Otp, String> {

}
