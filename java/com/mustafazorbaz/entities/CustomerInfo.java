package com.mustafazorbaz.entities;

public class CustomerInfo {
	private String id;
	private String createdAt;
	private String updatedAt;
	private String deletedAt;
	private long number;
	private String expiryMonth;
	private String  expiryYear;
	private String startMonth;
	private String startYear;
	private String  issueNumber; 
	private String email;
	private String  birthday;
	private String gender;
	private String billingTitle;
	private String  billingFirstName;
	private String billingLastName;
	private String billingCompany;
	private String  billingAddress1;
	private String billingAddress2;
	private String billingCity;
	private String  billingPostcode;
	private String billingState;
	private String billingCountry;
	private String  billingPhone;
	private String billingFax;
	private String shippingTitle;
	private String shippingFirstName;
	private String  shippingLastName;
	private String shippingCompany;
	private String shippingAddress1;
	private String shippingAddress2;
	private String  shippingCity;
	private String shippingPostcode;
	private String shippingState;
	private String shippingCountry;
	private String  shippingPhone;
	private String shippingFax;
	
	public CustomerInfo() {
		super();
		this.id = "";
		this.createdAt = "";
		this.updatedAt = "";
		this.deletedAt = "";
		this.number = 0;
		this.expiryMonth = "";
		this.expiryYear = "";
		this.startMonth = "";
		this.startYear = "";
		this.issueNumber = "";
		this.email = "";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String string) {
		this.createdAt = string;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public String getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public String getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public String getIssueNumber() {
		return issueNumber;
	}
	public void setIssueNumber(String issueNumber) {
		this.issueNumber = issueNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBillingTitle() {
		return billingTitle;
	}
	public void setBillingTitle(String billingTitle) {
		this.billingTitle = billingTitle;
	}
	public String getBillingFirstName() {
		return billingFirstName;
	}
	public void setBillingFirstName(String billingFirstName) {
		this.billingFirstName = billingFirstName;
	}
	public String getBillingLastName() {
		return billingLastName;
	}
	public void setBillingLastName(String billingLastName) {
		this.billingLastName = billingLastName;
	}
	public String getBillingCompany() {
		return billingCompany;
	}
	public void setBillingCompany(String billingCompany) {
		this.billingCompany = billingCompany;
	}
	public String getBillingAddress1() {
		return billingAddress1;
	}
	public void setBillingAddress1(String billingAddress1) {
		this.billingAddress1 = billingAddress1;
	}
	public String getBillingAddress2() {
		return billingAddress2;
	}
	public void setBillingAddress2(String billingAddress2) {
		this.billingAddress2 = billingAddress2;
	}
	public String getBillingCity() {
		return billingCity;
	}
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	public String getBillingPostcode() {
		return billingPostcode;
	}
	public void setBillingPostcode(String billingPostcode) {
		this.billingPostcode = billingPostcode;
	}
	public String getBillingState() {
		return billingState;
	}
	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}
	public String getBillingCountry() {
		return billingCountry;
	}
	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}
	public String getBillingPhone() {
		return billingPhone;
	}
	public void setBillingPhone(String billingPhone) {
		this.billingPhone = billingPhone;
	}
	public String getBillingFax() {
		return billingFax;
	}
	public void setBillingFax(String billingFax) {
		this.billingFax = billingFax;
	}
	public String getShippingTitle() {
		return shippingTitle;
	}
	public void setShippingTitle(String shippingTitle) {
		this.shippingTitle = shippingTitle;
	}
	public String getShippingFirstName() {
		return shippingFirstName;
	}
	public void setShippingFirstName(String shippingFirstName) {
		this.shippingFirstName = shippingFirstName;
	}
	public String getShippingLastName() {
		return shippingLastName;
	}
	public void setShippingLastName(String shippingLastName) {
		this.shippingLastName = shippingLastName;
	}
	public String getShippingCompany() {
		return shippingCompany;
	}
	public void setShippingCompany(String shippingCompany) {
		this.shippingCompany = shippingCompany;
	}
	public String getShippingAddress1() {
		return shippingAddress1;
	}
	public void setShippingAddress1(String shippingAddress1) {
		this.shippingAddress1 = shippingAddress1;
	}
	public String getShippingAddress2() {
		return shippingAddress2;
	}
	public void setShippingAddress2(String shippingAddress2) {
		this.shippingAddress2 = shippingAddress2;
	}
	public String getShippingCity() {
		return shippingCity;
	}
	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}
	public String getShippingPostcode() {
		return shippingPostcode;
	}
	public void setShippingPostcode(String shippingPostcode) {
		this.shippingPostcode = shippingPostcode;
	}
	public String getShippingState() {
		return shippingState;
	}
	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}
	public String getShippingCountry() {
		return shippingCountry;
	}
	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}
	public String getShippingPhone() {
		return shippingPhone;
	}
	public void setShippingPhone(String shippingPhone) {
		this.shippingPhone = shippingPhone;
	}
	public String getShippingFax() {
		return shippingFax;
	}
	public void setShippingFax(String shippingFax) {
		this.shippingFax = shippingFax;
	}
	
}
