package com.abc.services.user;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.abc.services.user.model.UserAccount;

import feign.Headers;

@FeignClient(name = "auth-service")
public interface AuthClient {

	@PostMapping("/")
	UserAccount AddUser(@RequestHeader("Authorization")String authCode , @RequestBody UserAccount account);
	
	@PostMapping("/oauth/token")
	@Headers("Content-Type: application/x-www-form-urlencoded")
	UserAccount AuthToken(@RequestHeader("Authorization") String authCode , Map<String,?> data);
	
}