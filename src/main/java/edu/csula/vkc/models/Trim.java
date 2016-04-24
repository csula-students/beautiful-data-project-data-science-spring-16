package edu.csula.vkc.models;

public class Trim {

	private long trim_id;
	private String trim;
	private String vehicle_type;
	private int no_of_Cylinder;
	private String engine_location;
	private String transmission;
	private String drive_system;
	private String fuel_type;
	private long style_id;
	private double price;
	private String milage;
	
	public Trim() {
		super();
	}

	public Trim(long trim_id, String trim, String vehicle_type, int no_of_Cylinder, String engine_location,
			String transmission, String drive_system, String fuel_type, long style_id, double price, String milage) {
		super();
		this.trim_id = trim_id;
		this.trim = trim;
		this.vehicle_type = vehicle_type;
		this.no_of_Cylinder = no_of_Cylinder;
		this.engine_location = engine_location;
		this.transmission = transmission;
		this.drive_system = drive_system;
		this.fuel_type = fuel_type;
		this.style_id = style_id;
		this.price = price;
		this.milage = milage;
	}

	public long getTrim_id() {
		return trim_id;
	}

	public void setTrim_id(long trim_id) {
		this.trim_id = trim_id;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public int getNo_of_Cylinder() {
		return no_of_Cylinder;
	}

	public void setNo_of_Cylinder(int no_of_Cylinder) {
		this.no_of_Cylinder = no_of_Cylinder;
	}

	public String getEngine_location() {
		return engine_location;
	}

	public void setEngine_location(String engine_location) {
		this.engine_location = engine_location;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getDrive_system() {
		return drive_system;
	}

	public void setDrive_system(String drive_system) {
		this.drive_system = drive_system;
	}

	public String getFuel_type() {
		return fuel_type;
	}

	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}

	public long getStyle_id() {
		return style_id;
	}

	public void setStyle_id(long style_id) {
		this.style_id = style_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMilage() {
		return milage;
	}

	public void setMilage(String milage) {
		this.milage = milage;
	}

}
