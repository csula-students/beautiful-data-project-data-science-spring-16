package edu.csula.vkc.models;

public class Model {
	long model_id;
	String model;
	String vehicle_type;
	int no_of_Cylinder;
	String engine_location;
	String transmission;
	String drive_system;
	String fuel_type;
	long style_id;
	
	public Model() {
		super();
	}

	public Model(long model_id, String model, String vehicle_type, int no_of_Cylinder, String engine_location,
			String transmission, String drive_system, String fuel_type, long style_id) {
		super();
		this.model_id = model_id;
		this.model = model;
		this.vehicle_type = vehicle_type;
		this.no_of_Cylinder = no_of_Cylinder;
		this.engine_location = engine_location;
		this.transmission = transmission;
		this.drive_system = drive_system;
		this.fuel_type = fuel_type;
		this.style_id = style_id;
	}

	public long getModel_id() {
		return model_id;
	}

	public void setModel_id(long model_id) {
		this.model_id = model_id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
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

	
	
	
	

	
}