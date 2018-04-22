package com.mustafazorbaz.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TransactionQuery {
	private String fromDate;
	private String toDate;
	private int  merchantId;
	private int  acquirerId;
	private String status;
	private String operation;
	private String paymentMethod;
	private String filterField;
	private String filterValue;
	private String errorCode;
	private int page;
	private int perPage;
	private int currentPage;
	private String nextPageUrl;
	private String prevPageUrl;
	private int from;
	private int to; 
	
	public TransactionQuery(){
		
	}
	public TransactionQuery(String string, String string2, int merchantId, int acquirerId, String status, String operation,
			String paymentMethod, String filterField, String filterValue, int page) {
		super();
		this.fromDate = string;
		this.toDate = string2;
		this.merchantId = merchantId;
		this.acquirerId = acquirerId;
		this.status = status;
		this.operation = operation;
		this.paymentMethod = paymentMethod;
		this.filterField = filterField;
		this.filterValue = filterValue;
		this.page = page;
	}
	private List<Data>data =new ArrayList<>();

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
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public int getAcquirerId() {
		return acquirerId;
	}
	public void setAcquirerId(int acquirerId) {
		this.acquirerId = acquirerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getFilterField() {
		return filterField;
	}
	public void setFilterField(String filterField) {
		this.filterField = filterField;
	}
	public String getFilterValue() {
		return filterValue;
	}
	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getNextPageUrl() {
		return nextPageUrl;
	}
	public void setNextPageUrl(String nextPageUrl) {
		this.nextPageUrl = nextPageUrl;
	}
	public String getPrevPageUrl() {
		return prevPageUrl;
	}
	public void setPrevPageUrl(String prevPageUrl) {
		this.prevPageUrl = prevPageUrl;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		 this.to = to;
	}
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	 
	
}
