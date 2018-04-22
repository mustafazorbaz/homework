package com.mustafazorbaz.entities;

public class TransactionReportResponse {

	private int count;
	private int total;
	private String currency;
	public TransactionReportResponse(int count, int total, String currency) {
		super();
		this.count = count;
		this.total = total;
		this.currency = currency;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
