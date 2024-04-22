package com.student_information_system.userdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.student_information_system.entities.Administartor_Entity;
import com.student_information_system.entities.CustomAdministrator;
import com.student_information_system.entities.CustomStudent;
import com.student_information_system.entities.Student_Entity;
import com.student_information_system.repositories.Administartor_repo;
import com.student_information_system.repositories.Student_repo;

@Service
public class ProjectUserDetail implements UserDetailsService  {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private Student_repo studentRepo;
	
	@Autowired
	private Administartor_repo administartor_repo;
	
	public String role;
	
	public void setRole(String role){
		this.role=role;
	}
	
	public UserDetails loadUserByUsername(String name)
	{
//		Student_Entity student = studentRepo.findById(name).get();
//		 Administartor_Entity administartor_Entity=administartor_repo.findById(name).get();
				if (role.equals(Role.ROLE_ADMIN.toString())) {
//				if (true) {
		 
					Administartor_Entity administrator = administartor_repo.findById(name).get();
					System.err.println(administrator);
					if (administrator != null) {
//						return new User(administrator.getId(), administrator.getPassword(), new ArrayList<>());
						return new CustomAdministrator(administrator);
					} else {
						throw new UsernameNotFoundException("Admin name is invalid");
					}
		 
				}
		 
				else if (role.equals(Role.ROLE_USER.toString())) {
//				else if (true) {
					
		 
					Student_Entity student_Entity = studentRepo.findById(name).get();
		 
					if (student_Entity != null) {
//						return new User(student.getEnrollmentNo(), student.getPassword(), new ArrayList<>());
						
						return new CustomStudent(student_Entity);
					} else {
						throw new UsernameNotFoundException("User name is invalid");
					}
		 
				}
		 
				else {
					System.out.println("Select Your Role Propurly..!!");
					return null;
				}
		 
			}
		 
}
