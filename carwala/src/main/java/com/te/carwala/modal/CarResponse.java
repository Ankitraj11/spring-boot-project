package com.te.carwala.modal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.te.carwala.dto.CarDetails;



public class CarResponse  {

	
	private List<CarDetails> carlist;
	private String msg;
	private boolean error;
	public List<CarDetails> getCarlist() {
		return carlist;
	}
	public void setCarlist(List<CarDetails> carlist) {
		this.carlist = carlist;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public CarResponse(List<CarDetails> carlist, String msg, boolean error) {
		super();
		this.carlist = carlist;
		this.msg = msg;
		this.error = error;
	}
	public CarResponse() {
		super();
	}
	
	
	
}
