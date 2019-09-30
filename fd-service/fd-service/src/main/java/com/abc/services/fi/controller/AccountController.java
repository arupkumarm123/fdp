package com.abc.services.fi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.fi.model.Account;
import com.abc.services.fi.repository.AccountRepository;

@RestController
public class AccountController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FinancialInstituteController.class);

	@Autowired
	AccountRepository accountRepository;

	@PostMapping("/account/{cust_id}")
	public Account add(@PathVariable("cust_id") Long custID, @RequestBody Account account) {
		LOGGER.info("Fi add: {}", account);
		return accountRepository.addAccount(custID , account);
	}

	@GetMapping("/account/{cust_id}")
	public List<Account> get(@PathVariable("cust_id")Long custID) {
		LOGGER.info("Account get: {}", custID);
		return accountRepository.customerAccounts(custID);
	}
	
	@DeleteMapping("/account/{cust_id}/{account_id}")
	public boolean delete(@PathVariable("cust_id" )Long custID , @PathVariable("account_id") Long accountID) {
		
		return accountRepository.delete(custID, accountID);
	}
}
