package edu.csula.vkc.models;

public class MPG7 {

	private double highway;
	private double city;

	public MPG7(){
		super();
	}
	
	public MPG7(double highway, double city) {
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
