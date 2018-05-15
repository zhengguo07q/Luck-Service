package com.goleee.luck.service.web.client;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.goleee.luck.service.web.domain.User;

@FeignClient(name = "luck-service-account")
public interface AccountServiceClient
{

	@RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountName}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	String getAccount(@PathVariable("accountName") String accountName);

	@RequestMapping(method = RequestMethod.POST, value = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	void createAccount(User user);

}
