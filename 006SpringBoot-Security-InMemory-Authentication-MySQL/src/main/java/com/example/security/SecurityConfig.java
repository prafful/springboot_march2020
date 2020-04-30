package com.example.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	//https://mkyong.com/spring-boot/spring-security-there-is-no-passwordencoder-mapped-for-the-id-null/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);
		auth.inMemoryAuthentication()
		.withUser("visitor").password("{noop}visitor123").roles("USER")
		.and()
		.withUser("manager").password("{noop}manager123").roles("USER", "MANAGER")
		.and()
		.withUser("admin").password("{noop}admin123").roles("USER", "MANAGER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		//.antMatchers(HttpMethod.GET, "/").permitAll()
		//.antMatchers(HttpMethod.GET, "/check").denyAll()
		.antMatchers(HttpMethod.GET, "/friend/**").hasAnyRole("ADMIN", "MANAGER", "USER")
		.antMatchers(HttpMethod.POST, "/friend/**").hasAnyRole("ADMIN", "MANAGER")
		.antMatchers(HttpMethod.PUT, "/friend/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.PATCH,"/friend/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/friend/**").hasAnyRole("ADMIN")
		.and()
		.httpBasic()
		.and()
		.csrf()
		.disable();
		
	}
	
	
	

}
