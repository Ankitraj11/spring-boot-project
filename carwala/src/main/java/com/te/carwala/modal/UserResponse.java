package com.te.carwala.modal;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserResponse {
	private String message;
	private boolean error;
	private String token;
	private   Collection<? extends GrantedAuthority> userRoles;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Collection<? extends GrantedAuthority> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Collection<? extends GrantedAuthority> userRoles) {
		this.userRoles = userRoles;
	}
	public UserResponse(String message, boolean error, String token, Collection<? extends GrantedAuthority> userRoles) {
		super();
		this.message = message;
		this.error = error;
		this.token = token;
		this.userRoles = userRoles;
	}
	
	
}
