package com.abc.services.fi.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.abc.fi.model.Transaction;

public class TransactionRepository {
	
    private  Map<Long,Map<Long,List<Transaction>>> transactions = new HashMap<>();
	
	public Transaction addTransaction(long customerID , Transaction transaction ) {
		
		Map<Long,List<Transaction>> customerTransactions =transactions.get(customerID);
		
		if (customerTransactions == null ) {
			customerTransactions  = new HashMap<>();
			transactions.put(customerID, new HashMap<>());
		}
		
		if(transactions.get(customerID).get(transaction.getBankID()) == null ) {
			transactions.get(customerID).put(transaction.getBankID(), new ArrayList<>());
		}
		List<Transaction> bankTransactions = transactions.get(customerID).get(transaction.getBankID());
		bankTransactions.add(transaction);
		return transaction;
	}
	
	public Map<Long, List<Transaction>> userTransactions(long customerID) {
		return transactions.get(customerID);
	}
}
