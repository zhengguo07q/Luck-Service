package com.goleee.luck.service.web.domain;

import java.io.Serializable;

/**
 * 菜单 值对象.
 * 
 * @author zg
 */
public class MenuPojo implements Serializable
{

	private static final long serialVersionUID = 1L;

	private String name;
	private String url;

	public MenuPojo(String name, String url)
	{
		this.name = name;
		this.url = url;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}
}