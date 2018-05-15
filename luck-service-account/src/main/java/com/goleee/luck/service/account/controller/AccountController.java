package com.goleee.luck.service.account.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goleee.luck.service.account.domain.Account;
import com.goleee.luck.service.account.domain.User;
import com.goleee.luck.service.account.service.AccountService;

@RestController
public class AccountController
{

	@Autowired
	private AccountService accountService;

	/**
	 * 通过用户名得到账户
	 * 
	 * @param name
	 * @return
	 */
	@PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	public Account getAccountByName(@PathVariable String name)
	{
		return accountService.findByName(name);
	}

	/**
	 * 通过授权得到账户信息
	 * 
	 * @param principal
	 * @return
	 */
	@RequestMapping(path = "/current", method = RequestMethod.GET)
	public Account getCurrentAccount(Principal principal)
	{
		return accountService.findByName(principal.getName());
	}

	/**
	 * 保存当前账户的信息
	 * 
	 * @param principal
	 * @param account
	 */
	@RequestMapping(path = "/current", method = RequestMethod.PUT)
	public void saveCurrentAccount(Principal principal, @Valid @RequestBody Account account)
	{
		accountService.saveChanges(principal.getName(), account);
	}

	/**
	 * 创建新的账户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public Account createNewAccount(@Valid @RequestBody User user)
	{
		return accountService.create(user);
	}
}
