package com.mustafazorbaz.entities;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private List<CustomerInfo>customerInfo =new ArrayList<>();
	private String transactionId;
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public List<CustomerInfo> getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(List<CustomerInfo> customerInfo) {
		this.customerInfo = customerInfo;
	}
	public void addCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo.add(customerInfo);
	}
}
