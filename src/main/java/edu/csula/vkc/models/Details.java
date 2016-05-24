package edu.csula.vkc.models;

public class Details {
	private String detailId;
	private int salePrice;
	private int milesRun;
	private String source;
	private int yearsOld;

	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Details(String detailId, int salePrice, int milesRun, String source, int yearsOld) {
		super();
		this.detailId = detailId;
		this.salePrice = salePrice;
		this.milesRun = milesRun;
		this.source = source;
		this.yearsOld = yearsOld;
	}

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public int getMilesRun() {
		return milesRun;
	}

	public void setMilesRun(int milesRun) {
		this.milesRun = milesRun;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getYearsOld() {
		return yearsOld;
	}

	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}

}