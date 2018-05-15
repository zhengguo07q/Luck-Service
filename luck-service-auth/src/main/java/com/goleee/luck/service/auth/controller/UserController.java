package com.goleee.luck.service.auth.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.goleee.luck.service.auth.domain.User;
import com.goleee.luck.service.auth.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController
{

	@Autowired
	private UserService userService;

	/**
	 * 获取账户的权限
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public Principal getUser(Principal principal)
	{
		return principal;
	}

	/**
	 * 提供创建账户的能力
	 * @param user
	 */
	@PreAuthorize("#oauth2.hasScope('server')")
	@RequestMapping(method = RequestMethod.POST)
	public void createUser(@Valid @RequestBody User user)
	{
		userService.create(user);
	}
}
