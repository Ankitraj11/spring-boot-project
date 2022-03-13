package com.te.carwala.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="cardetails")
public class CarDetails implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int carId;
	@Column
	private String carCompany;
	@Column
	private String fuelType;
	@Column
	private String carName;
	@Column
	private boolean powerSteering;
	
	@Column
	private String carImageUrl;
	@Column
	
	private String breakSystem;
	@Column
	private double showRoomPrice;
	@Column
	private double onRoadPrice;
	
	@Column
	private double mileage;
	@Column
	private int seatingCapacity;
    @Column
	private int engineCapacity;
    @Column
    private String gearType;
   
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id" ,referencedColumnName = "adminId")
    private AdminDetails adminDetails;
    
    
	

	
	public AdminDetails getAdminDetails() {
		return adminDetails;
	}
	public void setAdminDetails(AdminDetails adminDetails) {
		this.adminDetails = adminDetails;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	
	public String getCarImageUrl() {
		return carImageUrl;
	}
	public void setCarImageUrl(String carImageUrl) {
		this.carImageUrl = carImageUrl;
	}
	public String getCarCompany() {
		return carCompany;
	}
	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public boolean isPowerSteering() {
		return powerSteering;
	}
	public void setPowerSteering(boolean powerSteering) {
		this.powerSteering = powerSteering;
	}
	public String getBreakSystem() {
		return breakSystem;
	}
	public void setBreakSystem(String breakSystem) {
		this.breakSystem = breakSystem;
	}
	

	public double getShowRoomPrice() {
		return showRoomPrice;
	}
	public void setShowRoomPrice(double showRoomPrice) {
		this.showRoomPrice = showRoomPrice;
	}
	public double getOnRoadPrice() {
		return onRoadPrice;
	}
	public void setOnRoadPrice(double onRoadPrice) {
		this.onRoadPrice = onRoadPrice;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public int getEngineCapacity() {
		return engineCapacity;
	}
	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	public String getGearType() {
		return gearType;
	}
	public void setGearType(String gearType) {
		this.gearType = gearType;
	}
	
	
	
}
