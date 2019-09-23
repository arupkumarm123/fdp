package com.abc.fi.model;

public class Account {

	private Long customerID;
	private String bankID;
	private String branchID;
	private String accountNumber;
	private AccountType accountType;
	private String accountKey;

	public Account(Long customerID, String bankID, String branchID, String accountNumber, AccountType accountType,
			String accountKey) {
		super();
		this.customerID = customerID;
		this.bankID = bankID;
		this.branchID = branchID;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountKey = accountKey;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public String getBankID() {
		return bankID;
	}

	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

	public String getBranchID() {
		return branchID;
	}

	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getAccountKey() {
		return accountKey;
	}

	public void setAccountKey(String accountKey) {
		this.accountKey = accountKey;
	}

}
