package com.te.carwala.modal;

import java.util.List;

import com.te.carwala.dto.CarDetails;

public class UserCarResponse {

	private List<CarDetails> carDetails;
	private boolean error;
	public List<CarDetails> getCarDetails() {
		return carDetails;
	}
	public void setCarDetails(List<CarDetails> carDetails) {
		this.carDetails = carDetails;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public UserCarResponse(List<CarDetails> carDetails, boolean error) {
		super();
		this.carDetails = carDetails;
		this.error = error;
	}

	
	

}
