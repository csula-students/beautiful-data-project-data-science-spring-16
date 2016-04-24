package edu.csula.vkc.models;

public class Submodel {

	private long subModel_id;
	private String modelName;

	public Submodel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Submodel(long subModel_id, String modelName) {
		super();
		this.subModel_id = subModel_id;
		this.modelName = modelName;
	}

	public long getSubModel_id() {
		return subModel_id;
	}

	public void setSubModel_id(long subModel_id) {
		this.subModel_id = subModel_id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

}
