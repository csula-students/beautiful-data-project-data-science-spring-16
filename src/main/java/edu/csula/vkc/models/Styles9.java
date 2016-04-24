package edu.csula.vkc.models;

public class Styles9 {

	private long styleId;
	private String name;
	private int numOfDoors;
	// no mpg
	private Price9 price;
	private String vehicalType;
	private int noOfCylinder;
	private String engineLocation;
	private String driveSystem;
	//no fueltype feild
	private String trim;

	public Styles9(){
		super();
	}
	
	public Styles9(long styleId, String name, int numOfDoors, Price9 price, String vehicalType,
			int noOfCylinder, String engineLocation, String driveSystem, String trim) {
		super();
		this.styleId = styleId;
		this.name = name;
		this.numOfDoors = numOfDoors;
	
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

	
	public Price9 getPrice() {
		return price;
	}

	public void setPrice(Price9 price) {
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
