package com.goleee.luck.service.account.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.goleee.luck.service.account.domain.User;

@FeignClient(name = "luck-service-auth")
public interface AuthServiceClient
{
	@RequestMapping(method = RequestMethod.POST, value = "/uaa/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	void createUser(User user);
}
