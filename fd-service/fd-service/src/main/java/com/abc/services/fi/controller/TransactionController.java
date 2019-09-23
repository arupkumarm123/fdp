package com.abc.services.fi.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.fi.model.Transaction;
import com.abc.services.fi.repository.TransactionRepository;

@RestController
public class TransactionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FinancialInstituteController.class);

	
	@Autowired
	TransactionRepository transactionRepository;

	@PostMapping("/transaction/{cust_id}")
	public Transaction add(@PathVariable("cust_id") Long custID, @RequestBody Transaction transaction) {
		LOGGER.info("Transaction add: {}", transaction);
		return transactionRepository.addTransaction(custID, transaction);
	}
	
	@GetMapping("/transaction/{cust_id}")
	public Map<Long,List<Transaction>> get(@PathVariable("cust_id")Long custID) {
		LOGGER.info("Transaction get: {}", custID);
		return transactionRepository.userTransactions(custID);
	}
	
	

}
