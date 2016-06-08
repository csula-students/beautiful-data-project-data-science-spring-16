package edu.csula.vkc.third.models;

import java.util.List;

import edu.csula.vkc.third.models.MPG;

public class Vehicle {

	private long id;
	private String makeName;
	private String modelName;
	private String year;
	private String vehicleName;
	private int noOfDoors;
	private String vehicleType;
	private int noOfCylinder;
	private String engineLocation;
	private String transmission;
	private String driveSystem;
	private String fuelType;
	private String trim;
	private MPG milage;
	private int originalPrice;
	private int tmv;
	private List<Details> detail;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(long id, String makeName, String modelName, String year, String vehicleName, int noOfDoors,
			String vehicleType, int noOfCylinder, String engineLocation, String transmission, String driveSystem,
			String fuelType, String trim, MPG milage, int originalPrice, int tmv, List<Details> detail) {
		super();
		this.id = id;
		this.makeName = makeName;
		this.modelName = modelName;
		this.year = year;
		this.vehicleName = vehicleName;
		this.noOfDoors = noOfDoors;
		this.vehicleType = vehicleType;
		this.noOfCylinder = noOfCylinder;
		this.engineLocation = engineLocation;
		this.transmission = transmission;
		this.driveSystem = driveSystem;
		this.fuelType = fuelType;
		this.trim = trim;
		this.milage = milage;
		this.originalPrice = originalPrice;
		this.tmv = tmv;
		this.detail = detail;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMakeName() {
		return makeName;
	}

	public void setMakeName(String makeName) {
		this.makeName = makeName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public int getNoOfDoors() {
		return noOfDoors;
	}

	public void setNoOfDoors(int noOfDoors) {
		this.noOfDoors = noOfDoors;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getNoOfCylinder() {
		return noOfCylinder;
	}

	public void setNoOfCylinder(int noOfCylinder) {
		this.noOfCylinder = noOfCylinder;
	}

	public String getEngineLocation() {
		return engineLocation;
	}

	public void setEngineLocation(String engineLocation) {
		this.engineLocation = engineLocation;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getDriveSystem() {
		return driveSystem;
	}

	public void setDriveSystem(String driveSystem) {
		this.driveSystem = driveSystem;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}

	public MPG getMilage() {
		return milage;
	}

	public void setMilage(MPG milage) {
		this.milage = milage;
	}

	public int getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(int originalPrice) {
		this.originalPrice = originalPrice;
	}

	public int getTmv() {
		return tmv;
	}

	public void setTmv(int tmv) {
		this.tmv = tmv;
	}

	public List<Details> getDetail() {
		return detail;
	}

	public void setDetail(List<Details> detail) {
		this.detail = detail;
	}

}
