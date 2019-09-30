package com.abc.fi.model;

import java.math.BigDecimal;
import java.util.Date;

public class 	Transaction {

	private TransactionType type;
	private Date transactionDate;
	private BigDecimal amount;
	private String id;
	private Long accountID;
	private Long bankID;

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getAccountID() {
		return accountID;
	}

	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	public Long getBankID() {
		return bankID;
	}

	public void setBankID(Long bankID) {
		this.bankID = bankID;
	}

	public Transaction(TransactionType type, Date transactionDate, BigDecimal amount, String id, Long accountID,
			Long bankID) {
		super();
		this.type = type;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.id = id;
		this.accountID = accountID;
		this.bankID = bankID;
	}

}
