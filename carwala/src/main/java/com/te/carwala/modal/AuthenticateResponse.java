package com.te.carwala.modal;

public class AuthenticateResponse {

	private String jwt;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public AuthenticateResponse(String jwt) {
		super();
		this.jwt = jwt;
	}


	
}
