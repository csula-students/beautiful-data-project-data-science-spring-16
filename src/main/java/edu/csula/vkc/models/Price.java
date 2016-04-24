package edu.csula.vkc.models;

public class Price {

	private long priceId;
	private String usedTradeIn;
	private String usedTmvRetail;

	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Price(long priceId, String usedTradeIn, String usedTmvRetail) {
		super();
		this.priceId = priceId;
		this.usedTradeIn = usedTradeIn;
		this.usedTmvRetail = usedTmvRetail;
	}

	public long getPriceId() {
		return priceId;
	}

	public void setPriceId(long priceId) {
		this.priceId = priceId;
	}

	public String getUsedTradeIn() {
		return usedTradeIn;
	}

	public void setUsedTradeIn(String usedTradeIn) {
		this.usedTradeIn = usedTradeIn;
	}

	public String getUsedTmvRetail() {
		return usedTmvRetail;
	}

	public void setUsedTmvRetail(String usedTmvRetail) {
		this.usedTmvRetail = usedTmvRetail;
	}

}
