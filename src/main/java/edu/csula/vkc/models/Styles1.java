package edu.csula.vkc.models;

public class Styles1 {

	private long styleId;
	private String name;
	private int numOfDoors;
	private MPG1 mpg;
	private Price1 price;
	private String vehicalType;
	private int noOfCylinder;
	private String engineLocation;
	private String transmission;
	private String driveSystem;
	private String fuelType;
	private String trim;

	public Styles1() {
		super();

	}

	public Styles1(long styleId, String name, int numOfDoors, MPG1 mpg, Price1 price, String vehicalType,
			int noOfCylinder, String engineLocation, String transmission, String driveSystem, String fuelType,
			String trim) {
		super();
		this.styleId = styleId;
		this.name = name;
		this.numOfDoors = numOfDoors;
		this.mpg = mpg;
		this.price = price;
		this.vehicalType = vehicalType;
		this.noOfCylinder = noOfCylinder;
		this.engineLocation = engineLocation;
		this.transmission = transmission;
		this.driveSystem = driveSystem;
		this.fuelType = fuelType;
		this.trim = trim;
	}

	public long getStyleId() {
		return styleId;
	}

	public void setStyleId(long styleId) {
		this.styleId = styleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfDoors() {
		return numOfDoors;
	}

	public void setNumOfDoors(int numOfDoors) {
		this.numOfDoors = numOfDoors;
	}

	public MPG1 getMpg() {
		return mpg;
	}

	public void setMpg(MPG1 mpg) {
		this.mpg = mpg;
	}

	public String getVehicalType() {
		return vehicalType;
	}

	public void setVehicalType(String vehicalType) {
		this.vehicalType = vehicalType;
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

	public Price1 getPrice() {
		return price;
	}

	public void setPrice(Price1 price) {
		this.price = price;
	}

}
