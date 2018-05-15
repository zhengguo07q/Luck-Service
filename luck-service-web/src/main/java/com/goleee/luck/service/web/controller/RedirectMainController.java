package com.goleee.luck.service.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.goleee.luck.service.web.client.AccountServiceClient;
import com.goleee.luck.service.web.domain.User;

/**
 * 主页控制器.
 * 
 * @author zg
 */
@Controller
public class RedirectMainController
{
	@Autowired
	private AccountServiceClient accountServiceClient;

	/**
	 * URL跳转到主页
	 * 
	 * @return
	 */
	@GetMapping("/")
	public String root()
	{
		return "redirect:/index";
	}

	/**
	 * 跳转到BLOG页
	 * 
	 * @return
	 */
	@GetMapping("/index")
	public String index()
	{
		return "redirect:/blogs";
	}

	/**
	 * 跳转到登录界面
	 * 
	 * @return
	 */
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}

	/**
	 * 跳转到错误页
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/login-error")
	public String loginError(Model model)
	{
		model.addAttribute("loginError", true);
		model.addAttribute("errorMsg", "登陆失败，账号或者密码错误！");
		return "login";
	}

	/**
	 * 跳转到注册页
	 * 
	 * @return
	 */
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}

	/**
	 * 注册用户跳转到登录用户
	 * 
	 * @param user
	 * @param result
	 * @param redirect
	 * @return
	 */
	@PostMapping("/register")
	public String registerUser(User user)
	{
		accountServiceClient.createAccount(user);
		return "redirect:/login";
	}

	/**
	 * 跳转到搜索页
	 * 
	 * @return
	 */
	@GetMapping("/search")
	public String search()
	{
		return "search";
	}
}