package edu.csula.vkc.models;

public class Styles8 {

	private long styleId;
	private String name;
	private int numOfDoors;
	private MPG8 mpg;
	private Price8 price;
	private String vehicalType;
	private int noOfCylinder;
	private String engineLocation;
	private String driveSystem;
	//no fueltype feild
	private String trim;

	public Styles8(){
		super();
	}
	
	public Styles8(long styleId, String name, int numOfDoors, MPG8 mpg, Price8 price, String vehicalType,
			int noOfCylinder, String engineLocation, String driveSystem, String trim) {
		super();
		this.styleId = styleId;
		this.name = name;
		this.numOfDoors = numOfDoors;
		this.mpg = mpg;
		this.price = price;
		this.vehicalType = vehicalType;
		this.noOfCylinder = noOfCylinder;
		this.engineLocation = engineLocation;
		this.driveSystem = driveSystem;
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

	public MPG8 getMpg() {
		return mpg;
	}

	public void setMpg(MPG8 mpg) {
		this.mpg = mpg;
	}

	public Price8 getPrice() {
		return price;
	}

	public void setPrice(Price8 price) {
		this.price = price;
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

	public String getDriveSystem() {
		return driveSystem;
	}

	public void setDriveSystem(String driveSystem) {
		this.driveSystem = driveSystem;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}




}
