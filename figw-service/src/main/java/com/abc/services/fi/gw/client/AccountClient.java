package com.abc.services.fi.gw.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.abc.fi.model.Account;

@FeignClient(name = "fi-service")
public interface AccountClient {

	@GetMapping("/account/{cust_id}")
	List<Account> findAccountForCustomer(@PathVariable("cust_id") Long custID);
	
	@PostMapping("/account/{cust_id}")
	public Account add(@PathVariable("cust_id") Long custID, @RequestBody Account account);
	
}
