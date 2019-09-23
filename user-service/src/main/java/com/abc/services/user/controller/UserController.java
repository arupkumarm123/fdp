package com.abc.services.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.services.user.AuthClient;
import com.abc.services.user.model.User;
import com.abc.services.user.model.UserAccount;
import com.abc.services.user.repository.UserRepository;
;

@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserRepository repository;
	
	@Value("${auth.code}")
	String authCode;
	
	@Value("${auth.basicauth}")
	String clientAuth;
	
	
	@Autowired
	AuthClient authClient;
	
	@PostMapping("/")
	public User add(@RequestBody User user) {
		LOGGER.info("User add: {}", user);
		User savedUser = repository.add(user);
		
		UserAccount account = new UserAccount();
		account.setPassword(user.getPassword());
		LOGGER.info("Auth Token: {}" , authCode);
		LOGGER.info("Client Auth Token: {}" , clientAuth);

		authClient.AddUser(authCode , account);
		Map<String,String> grantType = new HashMap<>();
		
		grantType.put("grant_type", "client_credentials");
		authClient.AuthToken(clientAuth, grantType);
		return savedUser;
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable("id") Long id) {
		LOGGER.info("User find: id={}", id);
		return repository.findById(id);
	}
	
	@GetMapping("/")
	public List<User> findAll() {
		LOGGER.info("User find");
		return repository.findAll();
	}
	
	@GetMapping("/{email}")
	public List<User> findByEmail(@PathVariable("email") String email) {
		LOGGER.info("User find: email={}", email);
		return repository.findByEmail(email);
	}
	
}
