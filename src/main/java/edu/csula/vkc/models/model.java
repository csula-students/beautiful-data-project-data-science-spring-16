package edu.csula.vkc.models;

import java.util.ArrayList;
import java.util.List;

public class model {
	int model_id;
	String model;
	String vehicle_type;
	int no_of_Cylinder;
	String transmission;
	String drive_system;
	double price;
	List<trim> trimList = new ArrayList<>();

	public model() {
		super();
	}

	public model(int model_id, String model, List<trim> trimList) {
		super();
		this.model_id = model_id;
		this.model = model;
		this.trimList = trimList;
	}

	public int getModel_id() {
		return model_id;
	}

	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<trim> getTrimList() {
		return trimList;
	}

	public void setTrimList(List<trim> trimList) {
		this.trimList = trimList;
	}

}