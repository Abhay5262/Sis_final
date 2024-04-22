package com.student_information_system.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomAdministrator implements UserDetails {

	private Administartor_Entity administartor_Entity;
	
	@Autowired
	private PasswordEncoder encoder;
	public CustomAdministrator (Administartor_Entity  administartor_Entity) {
		this.administartor_Entity=administartor_Entity;
	} 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority>authorities=new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(administartor_Entity.getRole()));
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return encoder.encode(administartor_Entity.getPassword());
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return administartor_Entity.getId();
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
