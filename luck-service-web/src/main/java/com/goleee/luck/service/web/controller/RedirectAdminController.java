package com.goleee.luck.service.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.goleee.luck.service.web.domain.MenuPojo;

/**
 * 用户控制器.
 * 
 * @author zg
 */
@Controller
@RequestMapping("/admins")
public class RedirectAdminController
{

	/**
	 * 跳转到后台管理主页面
	 * 
	 * @return
	 */
	@GetMapping
	public ModelAndView listUsers(Model model)
	{
		List<MenuPojo> list = new ArrayList<>();
		list.add(new MenuPojo("用户管理", "/users"));
		model.addAttribute("list", list);
		return new ModelAndView("admins/index", "model", model);
	}
}
