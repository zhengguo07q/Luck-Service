package com.goleee.luck.service.notification.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goleee.luck.service.notification.domain.Recipient;
import com.goleee.luck.service.notification.service.RecipientService;

@RestController
@RequestMapping("/recipients")
public class RecipientController
{

	@Autowired
	private RecipientService recipientService;

	@RequestMapping(path = "/current", method = RequestMethod.GET)
	public Object getCurrentNotificationsSettings(Principal principal)
	{
		return recipientService.findByAccountName(principal.getName());
	}

	@RequestMapping(path = "/current", method = RequestMethod.PUT)
	public Object saveCurrentNotificationsSettings(Principal principal, @Valid @RequestBody Recipient recipient)
	{
		return recipientService.save(principal.getName(), recipient);
	}
}
