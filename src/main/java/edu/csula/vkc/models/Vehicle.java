package edu.csula.vkc.models;

import java.util.List;

public class Vehicle {

	private long vehicle_id;
	private String make_name;
	private String model_make;
	private String year;
	private String vehicle_name;
	private int no_of_doors;
	private String vehicle_type;
	private int no_of_cylinder;
	private String engine_location;
	private String transmission;
	private String drive_system;
	private String fuel_type;
	private String trim;
	private MPG milage;
	private int original_price;
	private List<Details> detail;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(long vehicle_id, String make_name, String model_make, String year, String vehicle_name,
			int no_of_doors, String vehicle_type, int no_of_cylinder, String engine_location, String transmission,
			String drive_system, String fuel_type, String trim, MPG milage, int original_price, List<Details> detail) {
		super();
		this.vehicle_id = vehicle_id;
		this.make_name = make_name;
		this.model_make = model_make;
		this.year = year;
		this.vehicle_name = vehicle_name;
		this.no_of_doors = no_of_doors;
		this.vehicle_type = vehicle_type;
		this.no_of_cylinder = no_of_cylinder;
		this.engine_location = engine_location;
		this.transmission = transmission;
		this.drive_system = drive_system;
		this.fuel_type = fuel_type;
		this.trim = trim;
		this.milage = milage;
		this.original_price = original_price;
		this.detail = detail;
	}

	public long getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(long vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getMake_name() {
		return make_name;
	}

	public void setMake_name(String make_name) {
		this.make_name = make_name;
	}

	public String getModel_make() {
		return model_make;
	}

	public void setModel_make(String model_make) {
		this.model_make = model_make;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getVehicle_name() {
		return vehicle_name;
	}

	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}

	public int getNo_of_doors() {
		return no_of_doors;
	}

	public void setNo_of_doors(int no_of_doors) {
		this.no_of_doors = no_of_doors;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public int getNo_of_cylinder() {
		return no_of_cylinder;
	}

	public void setNo_of_cylinder(int no_of_cylinder) {
		this.no_of_cylinder = no_of_cylinder;
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

	public int getOriginal_price() {
		return original_price;
	}

	public void setOriginal_price(int original_price) {
		this.original_price = original_price;
	}

	public List<Details> getDetail() {
		return detail;
	}

	public void setDetail(List<Details> detail) {
		this.detail = detail;
	}

}
