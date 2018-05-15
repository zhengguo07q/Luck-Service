package com.goleee.luck.service.userclaim.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.goleee.luck.service.account.domain.Account;
import org.goleee.luck.service.account.domain.User;
import org.goleee.luck.service.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goleee.luck.service.userclaim.service.UserClaimService;

@RestController
public class UserClaimController
{
	@Autowired
	private UserClaimService userClaimtService;

	@PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	public UserClaim getUserClaimByName(@PathVariable String name)
	{
		return userClaimtService.findByName(name);
	}

	@RequestMapping(path = "/current", method = RequestMethod.GET)
	public UserClaim getCurrentAccount(Principal principal)
	{
		return userClaimtService.findByName(principal.getName());
	}

	@RequestMapping(path = "/current", method = RequestMethod.PUT)
	public void saveCurrentAccount(Principal principal, @Valid @RequestBody Account account)
	{
		userClaimtService.saveChanges(principal.getName(), account);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public UserClaim createNewAccount(@Valid @RequestBody User user)
	{
		return userClaimtService.create(user);
	}
}
