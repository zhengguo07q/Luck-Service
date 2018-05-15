package com.goleee.luck.service.userclaim.domain;

/**
 * 详细的要求，只有会员才有
 * 
 * @author zg
 *
 */
public class UserClaimDetail extends UserClaim
{

	/**
	 * 在线要求
	 */
	private LoginTimeType loginTime = LoginTimeType.Online;

	/**
	 * 信用等级
	 */
	private CreditLevelType creditLevel = CreditLevelType.Low;

	/**
	 * 是否有房子
	 */
	private ClaimYesOrNoType hasHouse = ClaimYesOrNoType.No;

	/**
	 * 是否有车
	 */
	private ClaimYesOrNoType hasCar = ClaimYesOrNoType.No;

	/**
	 * 星座类型
	 */
	private ConstellationType constellation = ConstellationType.Leo;

	/**
	 * 行业类型
	 */
	private int profession;

	/**
	 * 民族
	 */
	private int nation;

	/**
	 * 籍贯
	 */
	private int nativePlace;

	/**
	 * 婚姻状况
	 */
	private int maritalStatus;
}
