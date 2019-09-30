package com.abc.services.fi.gw.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.abc.fi.model.Account;
import com.abc.fi.model.Transaction;
import com.abc.services.fi.gw.client.AccountClient;
import com.abc.services.fi.gw.client.FIClient;
import com.abc.services.fi.gw.client.MetadataClient;
import com.abc.services.fi.meta.MetaDef;
import com.abc.services.fi.model.EndPoint;
import com.abc.services.fi.model.EndPointType;
import com.abc.services.fi.model.EndPoints;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
public class FIGatewayController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FIGatewayController.class);

	@Autowired
	AccountClient accountClient;

	@Autowired
	FIClient fiClient;
	
	@Autowired
	MetadataClient metadataClient;
	

	@PostMapping("/fi/{fiID}/account/{accountID}")
	public Account account(@PathVariable("fiID") Long fiID, @PathVariable("accountID") Long accountID) {
		LOGGER.info("Account Details for: {} customerID {}", fiID, accountID);
		EndPoint linkEndPoint;

		EndPoints endPoints = fiClient.getEndPoints(fiID);

		Optional<EndPoint> acLinkEndpoint = endPoints.getEndpoints().stream()
				.filter(ep -> ep.getEndPointType() == EndPointType.LINK).findFirst();

		if (acLinkEndpoint.isPresent()) {
			linkEndPoint = acLinkEndpoint.get();
		} else {
			return null;
		}
		String url = linkEndPoint.getServiceDef().getUrl();
		List<MetaDef> serviceMeta = metadataClient.get(fiID);
		MetaDef accountMeta;
		
		Optional<MetaDef> accountObjectMeta = serviceMeta.stream().filter(m -> m.getObjectType() == MetaDef.Type.Account).findFirst();
		if(accountObjectMeta.isPresent()) {
			accountMeta = accountObjectMeta.get();
		}
		else {
			LOGGER.info("failed account meta retrieval for FI {}", fiID);

			return null;
		}
		LOGGER.info("Url is {}", url);
		url = String.format("%s/%d", url, accountID);
		LOGGER.info("Url is {}", url);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> resp = restTemplate.getForEntity(url, String.class);
		LOGGER.info("this is the response {}", resp.getBody());

		JsonParser parser = new JsonParser();
		
		if (resp.getStatusCode() != HttpStatus.OK && resp.getStatusCode() != HttpStatus.CREATED) {
			return null;
		}
		JsonArray accounts = parser.parse(resp.getBody()).getAsJsonArray();
		
		if(accounts.size() >= 1) {
			JsonObject accountObject = accounts.get(0).getAsJsonObject();
			JsonObject  changedAccount = new JsonObject();
			accountObject.keySet().forEach( key -> {
				JsonElement accountAtt = accountObject.get(key);
				//accountObject.remove(key);
				String changedKey = accountMeta.getFields().get(key);
				
				if (changedKey == null) {
					changedKey = key;
				}
				changedAccount.add(changedKey, accountAtt);
				
			});
			LOGGER.info("this is the changed response {}", changedAccount);
			Gson gson = new Gson();
			Account ac =  gson.fromJson(changedAccount, Account.class);
			accountClient.add(ac.getCustomerID(), ac);
			
			return ac;

		}
		
		return null;
	}
	
	@GetMapping("/fi/{fiID}/customer/{custID}/transactions")
	public List<Transaction> transaction(@PathVariable("fiID")  Long fiID , @PathVariable("custID") Long custID) {
		
		LOGGER.info("Transaction Details for FI: {} custID {}", fiID, custID);
		EndPoint transactionEndpoint;

		EndPoints endPoints = fiClient.getEndPoints(fiID);

		Optional<EndPoint> tranEndpoint = endPoints.getEndpoints().stream()
				.filter(ep -> ep.getEndPointType() == EndPointType.TRANSACTION).findFirst();

		if (tranEndpoint.isPresent()) {
			transactionEndpoint = tranEndpoint.get();
		} else {
			LOGGER.info("failed transaction endPoint retrieval for FI {}", fiID);
			return null;
		}
		String url = transactionEndpoint.getServiceDef().getUrl();
		List<MetaDef> serviceMeta = metadataClient.get(fiID);
		MetaDef tranMeta;
		
		Optional<MetaDef> tranObjectMedata = serviceMeta.stream().filter(m -> m.getObjectType() == MetaDef.Type.Transaction).findFirst();
		if(tranObjectMedata.isPresent()) {
			tranMeta = tranObjectMedata.get();
		}
		else {
			LOGGER.info("failed transaction meta retrieval for FI {}", fiID);

			return null;
		}
		LOGGER.info("Url is {}", url);
		url = String.format("%s/%d", url, custID);
		LOGGER.info("Url is {}", url);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> resp = restTemplate.getForEntity(url, String.class);
		LOGGER.info("this is the response {}", resp.getBody());

		JsonParser parser = new JsonParser();
		
		if (resp.getStatusCode() != HttpStatus.OK && resp.getStatusCode() != HttpStatus.CREATED) {
			return null;
		}
		JsonArray transactions = parser.parse(resp.getBody()).getAsJsonArray();
		
		if(transactions.size() >= 1) {
			JsonArray changedTransactions = new JsonArray();
			for( JsonElement transactionElement : transactions) {
				
				JsonObject transactionObject = transactionElement.getAsJsonObject();
				JsonObject  changedTransaction = new JsonObject();
				transactionObject.keySet().forEach(key -> {
					JsonElement tranAttr = transactionObject.get(key);
					String changedKey = tranMeta.getFields().get(key);
					
					if (changedKey == null) {
						changedKey = key;
					}
					changedTransaction.add(changedKey, tranAttr);
					
				});
				
				changedTransactions.add(changedTransaction);
				
			}
			
			LOGGER.info("this is the changed response {}", changedTransactions);
			Gson gson = new Gson();
			List<Transaction> changedTran =  gson.fromJson(changedTransactions, List.class);
			
			return changedTran;

		}
		
		return null;
		
	}
	
	
}
