package edu.csula.vkc.second.models;

public class MPG {

	private double highway;
	private double city;

	public MPG(){
		super();
	}
	
	public MPG(double highway, double city) {
		super();
		this.highway = highway;
		this.city = city;
	}

	public double getHighway() {
		return highway;
	}

	public void setHighway(double highway) {
		this.highway = highway;
	}

	public double getCity() {
		return city;
	}

	public void setCity(double city) {
		this.city = city;
	}
}
