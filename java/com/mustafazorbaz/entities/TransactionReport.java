package com.mustafazorbaz.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TransactionReport {
	private String fromDate;
	private String toDate;
	private String status;
	private int  merchant;
	private int  acquirer;
	private List<TransactionReportResponse>response =new ArrayList<>();
	
	public TransactionReport(String fromDate, String toDate, int merchant, int acquirer) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.merchant = merchant;
		this.acquirer = acquirer;
	}
	public TransactionReport() {
		 
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public int getMerchant() {
		return merchant;
	}
	public void setMerchant(int merchant) {
		this.merchant = merchant;
	}
	public int getAcquirer() {
		return acquirer;
	}
	public void setAcquirer(int acquirer) {
		this.acquirer = acquirer;
	}
	public List<TransactionReportResponse> getResponse() {
		return response;
	}
	public void addResponse(TransactionReportResponse reportResponse) {
		this.response.add( reportResponse);
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
