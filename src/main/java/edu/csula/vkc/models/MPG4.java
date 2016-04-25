package edu.csula.vkc.models;

public class MPG4 {

	private double highway;
	private double city;

	public MPG4(){
		super();
	}
	
	public MPG4(double highway, double city) {
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
