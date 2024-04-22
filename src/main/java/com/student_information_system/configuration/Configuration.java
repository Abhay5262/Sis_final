package com.student_information_system.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.student_information_system.filters.PreFilter;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class Configuration extends WebSecurityConfigurerAdapter{
		
		

		@Autowired
		private PreFilter filters;
		 
		@Bean
		public AuthenticationManager authenticationManager() throws Exception
		{
			return super.authenticationManager();
		}
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			 super.configure(auth);
		}
	 
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// TODO Auto-generated method stub
			http.cors(c->c.disable())
			.csrf(cr->cr.disable())
			.authorizeHttpRequests(auth->auth.antMatchers("/auth/**","/auth/forgot/**","/auth/verify/**","/user/register","/admin/updateAdmin/**").permitAll()
					.antMatchers("/user/**").hasRole("USER")
					.antMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated())
			.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
			
			http.addFilterBefore(filters, UsernamePasswordAuthenticationFilter.class);
			
		
		}


	 
	}

