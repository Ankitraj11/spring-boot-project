package com.te.carwala.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.te.carwala.filter.JwtRequestFilter;
import com.te.carwala.utill.JwtUtill;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
    
	@Autowired
	private JwtRequestFilter filter;
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable()
		.cors();
		http.authorizeRequests()
		.antMatchers("/admin/getcarDetails").hasRole("ADMIN")
		.antMatchers("/admin/addCar").hasRole("ADMIN")
		.antMatchers("/admin/updateCar").hasRole("ADMIN")
		.antMatchers("/admin/deleteCar").hasRole("ADMIN")
		.antMatchers("/user/getCarByName/{carname}").permitAll()
		.antMatchers("/user/getCarByCompany/{company}").permitAll()
		.antMatchers("/user/getCarByfuelType/{fuelType}").permitAll()
		//.antMatchers("/admin/get").hasRole("ADMIN")
		.antMatchers("/admin/signUp").permitAll()
		.antMatchers("/superAdmin/signUp").permitAll()
		.antMatchers("/superAdmin/logIn").permitAll()
		.antMatchers("/superAdmin/getAllCar").hasRole("SUPERADMIN")
		.antMatchers("/admin/loggedIn").permitAll().anyRequest().authenticated()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	public PasswordEncoder getEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
