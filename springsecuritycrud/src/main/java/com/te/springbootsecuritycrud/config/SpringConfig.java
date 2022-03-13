package com.te.springbootsecuritycrud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SpringConfig extends WebSecurityConfigurerAdapter {

	@Autowired 
	private UserDetailsService detailsService;
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
	        auth.userDetailsService(detailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable()
		.cors().disable()
		.authorizeRequests()
		.antMatchers("/admin")
		.hasRole("ADMIN")
		.antMatchers("/user")
		.hasAnyRole("ADMIN","USER") 
	      
		.antMatchers("/seeUserById")
		.hasAnyRole("ADMIN","USER")
		.antMatchers("/seeAllUser")
		.hasRole("ADMIN")
		
		.antMatchers("/addUser")
		.hasRole("ADMIN")
	
		.antMatchers("/welcome").permitAll()
		.and().formLogin();
	
		
	}
     @Bean
	public PasswordEncoder getEncoder() {
    	 return NoOpPasswordEncoder.getInstance();
     }
	
	
}
