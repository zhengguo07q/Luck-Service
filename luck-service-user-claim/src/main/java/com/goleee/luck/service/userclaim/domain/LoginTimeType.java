package com.goleee.luck.service.userclaim.domain;

/**
 * 登录时间类型
 * 默认为Year, 就是没有要求
 * @author zg
 *
 */
public enum LoginTimeType
{
	/**
	 * 在线
	 */
	Online,
	
	/**
	 * 最近一天
	 */
	RecentlyOne,
	
	/**
	 * 最近三天
	 */
	RecentlyThree,
	
	/**
	 * 本周内
	 */
	Week,
	
	/**
	 * 本月内
	 */
	Month,
	
	/**
	 * 本年内
	 */
	Year,
}
