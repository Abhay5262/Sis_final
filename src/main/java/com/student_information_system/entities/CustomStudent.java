package com.student_information_system.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomStudent implements UserDetails {

	private Student_Entity student_Entity;
	@Autowired
	private PasswordEncoder encoder;
	
	public CustomStudent (Student_Entity student_Entity) {
		this.student_Entity=student_Entity;
	} 
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority>authorities=new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(student_Entity.getRole()));
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return encoder.encode(student_Entity.getPassword()) ;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return student_Entity.getEnrollmentNo();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
