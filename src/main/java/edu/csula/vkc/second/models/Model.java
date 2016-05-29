package edu.csula.vkc.second.models;

import java.util.List;

public class Model {
	
	private long model_id;
	private String model;
	private List<Years> year;
	
	public Model() {
		super();
	}

	public Model(long model_id, String model, List<Years> year) {
		super();
		this.model_id = model_id;
		this.model = model;
		this.year = year;
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

	public List<Years> getYear() {
		return year;
	}

	public void setYear(List<Years> year) {
		this.year = year;
	}
}