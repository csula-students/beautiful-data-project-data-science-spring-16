package edu.csula.vkc.models;

public class MPG2 {

	private double highway;
	private double city;

	public MPG2(){
		super();
	}
	
	public MPG2(double highway, double city) {
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
