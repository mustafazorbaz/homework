package com.mustafazorbaz.entities;

public class Merchant {

	private int merchantId;
	private int originalAmount;
	private String originalCurrency;
	private String referenceNo;
	private String status;
	private String channel;
	private String customData;
	private String chainId;
	private int agentInfoId;
	private String operation;
	private int fxTransactionId;
	private String updatedAt;
	private String  createdAt;
	private int id;
	private int acquirerTransactionId;
	private int code;
	private String message;
	private String transactionId;
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public int getOriginalAmount() {
		return originalAmount;
	}
	public void setOriginalAmount(int originalAmount) {
		this.originalAmount = originalAmount;
	}
	public String getOriginalCurrency() {
		return originalCurrency;
	}
	public void setOriginalCurrency(String originalCurrency) {
		this.originalCurrency = originalCurrency;
	}
	public String getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getCustomData() {
		return customData;
	}
	public void setCustomData(String customData) {
		this.customData = customData;
	}
	public String getChainId() {
		return chainId;
	}
	public void setChainId(String chainId) {
		this.chainId = chainId;
	}
	public int getAgentInfoId() {
		return agentInfoId;
	}
	public void setAgentInfoId(int agentInfoId) {
		this.agentInfoId = agentInfoId;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getFxTransactionId() {
		return fxTransactionId;
	}
	public void setFxTransactionId(int fxTransactionId) {
		this.fxTransactionId = fxTransactionId;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAcquirerTransactionId() {
		return acquirerTransactionId;
	}
	public void setAcquirerTransactionId(int acquirerTransactionId) {
		this.acquirerTransactionId = acquirerTransactionId;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	  
}
