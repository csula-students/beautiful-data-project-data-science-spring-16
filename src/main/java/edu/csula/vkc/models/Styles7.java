package edu.csula.vkc.models;

public class Styles7 {

	private long styleId;
	private String name;
	private int numOfDoors;
	private MPG7 mpg;
	private Price7 price;
	private String vehicalType;
//no no of cylinders feild
	private String engineLocation;
	private String driveSystem;
	private String fuelType;
	private String trim;

	public Styles7(){
		super();
	}
	
	
	
	public Styles7(long styleId, String name, int numOfDoors, MPG7 mpg, Price7 price, String vehicalType,
			 String engineLocation, String driveSystem, String fuelType, String trim) {
		super();
		this.styleId = styleId;
		this.name = name;
		this.numOfDoors = numOfDoors;
		this.mpg = mpg;
		this.price = price;
		this.vehicalType = vehicalType;
		this.engineLocation = engineLocation;
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

	public MPG7 getMpg() {
		return mpg;
	}

	public void setMpg(MPG7 mpg) {
		this.mpg = mpg;
	}

	public String getVehicalType() {
		return vehicalType;
	}

	public void setVehicalType(String vehicalType) {
		this.vehicalType = vehicalType;
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

	public Price7 getPrice() {
		return price;
	}

	public void setPrice(Price7 price) {
		this.price = price;
	}

}
