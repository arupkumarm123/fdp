package com.abc.services.fi.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.abc.fi.model.Account;

public class AccountRepository {

	private  Map<Long,List<Account>> customerAccount = new HashMap<>();
	
	public Account addAccount(long customerID , Account account ) {
		
		List<Account> customerAccounts =customerAccount.get(customerID);
		
		if (customerAccounts == null ) {
			customerAccounts  = new ArrayList<>();
		}
		
		customerAccounts.add(account);
		customerAccount.put(customerID, customerAccounts);
		return account;
	}
	
	public List<Account> customerAccounts(long customerID) {
		return customerAccount.get(customerID);
	}
	
	public boolean delete(long customerID , long accountID) {
		
		List<Account> accounts = customerAccounts(customerID);
		boolean success = accounts.removeIf(account -> account.getID() == accountID);
		
		if(success) {
			
			// apply transaction cleaning and message for serving layer
		}
		
		return success;
	}
}
