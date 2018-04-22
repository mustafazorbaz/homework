package com.mustafazorbaz.entities;

import java.util.ArrayList;
import java.util.List;

public class Data {
 	private List<Fx>response =new ArrayList<>();
	private List<CustomerInfo>customerInfo =new ArrayList<>();
	private List<Merchant>merchant =new ArrayList<>();
	private List<Ipn>ipn =new ArrayList<>();
	private List<Transaction>transaction =new ArrayList<>();
	private List<Acquirer>acquirer =new ArrayList<>();
	public List<Fx> getResponse() {
		return response;
	}
	public void setResponse(List<Fx> response) {
		this.response = response;
	}
	public void addResponse(Fx fx) {
		this.response.add(fx);
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
	public List<Merchant> getMerchant() {
		return merchant;
	}
	public void setMerchant(List<Merchant> merchant) {
		this.merchant = merchant;
	}
	public void addMerchant(Merchant merchant) {
		this.merchant.add(merchant);
	}
	public List<Ipn> getIpn() {
		return ipn;
	}
	public void setIpn(List<Ipn> ipn) {
		this.ipn = ipn;
	}
	public void addIpn(Ipn ipn) {
		this.ipn.add(ipn);
	}
	public List<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	public void addTransaction(Transaction transaction) {
		this.transaction.add(transaction);
	}
	public List<Acquirer> getAcquirer() {
		return acquirer;
	}
	public void setAcquirer(List<Acquirer> acquirer) {
		this.acquirer = acquirer;
	}
	public void addAcquirer(Acquirer acquirer) {
		this.acquirer.add(acquirer);
	} 
}
