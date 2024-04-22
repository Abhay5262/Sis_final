package com.student_information_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student_information_system.entities.Administartor_Entity;
import java.util.List;


@Repository
public interface Administartor_repo extends JpaRepository<Administartor_Entity, String>  {

	

	   @Query(value = "SELECT * from Administartor_Entity WHERE email=:email",nativeQuery = true)
		Administartor_Entity findEmailId(String email);
	   
//	   List<Administartor_Entity> findByEmail(String email);

	
	
}
