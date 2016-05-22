package edu.csula.vkc.models;

public class Details {
	private long detail_id;
	private int sale_price;
	private int miles_run;
	private String source;
	private int years_old;

	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Details(long detail_id, int sale_price, int miles_run, String source, int years_old) {
		super();
		this.detail_id = detail_id;
		this.sale_price = sale_price;
		this.miles_run = miles_run;
		this.source = source;
		this.years_old = years_old;
	}

	public long getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(long detail_id) {
		this.detail_id = detail_id;
	}

	public int getSale_price() {
		return sale_price;
	}

	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}

	public int getMiles_run() {
		return miles_run;
	}

	public void setMiles_run(int miles_run) {
		this.miles_run = miles_run;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getYears_old() {
		return years_old;
	}

	public void setYears_old(int years_old) {
		this.years_old = years_old;
	}

}
