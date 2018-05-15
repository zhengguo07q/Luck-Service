package com.goleee.luck.service.userclaim.domain;

/**
 * 普通的用户的要求
 * 
 * @author zg
 *
 */
public class UserClaim
{
	/**
	 * 年龄要求
	 */
	private ClaimYesOrNoType ageClaim = ClaimYesOrNoType.No;

	/**
	 * 最小年龄
	 */
	private int ageMin;

	/**
	 * 最大年纪
	 */
	private int ageMax;

	/**
	 * 住址要求
	 */
	private ClaimYesOrNoType addressClaim = ClaimYesOrNoType.No;

	/**
	 * 省份
	 */
	private AddressProvinceType provinceType = AddressProvinceType.Beijing;

	/**
	 * 城市
	 */
	private AddressCityType cityType = AddressCityType.Beijing;

	/**
	 * 最大身高
	 */
	private int statureMax = 200;

	/**
	 * 最小身高
	 */
	private int statureMin = 150;

	/**
	 * 学历要求
	 */
	private ClaimEducationType educationClaim = ClaimEducationType.No;

	/**
	 * 最小月收入要求
	 */
	private ClaimMonthlyIncomeType monthlyIncomeMin = ClaimMonthlyIncomeType.m2000;

	/**
	 * 最大月收入要求
	 */
	private ClaimMonthlyIncomeType monthlyIncomeMax = ClaimMonthlyIncomeType.m50000;

	public ClaimYesOrNoType getAgeClaim()
	{
		return ageClaim;
	}

	public void setAgeClaim(ClaimYesOrNoType ageClaim)
	{
		this.ageClaim = ageClaim;
	}

	public int getAgeMin()
	{
		return ageMin;
	}

	public void setAgeMin(int ageMin)
	{
		this.ageMin = ageMin;
	}

	public int getAgeMax()
	{
		return ageMax;
	}

	public void setAgeMax(int ageMax)
	{
		this.ageMax = ageMax;
	}

	public ClaimYesOrNoType getAddressClaim()
	{
		return addressClaim;
	}

	public void setAddressClaim(ClaimYesOrNoType addressClaim)
	{
		this.addressClaim = addressClaim;
	}

	public AddressProvinceType getProvinceType()
	{
		return provinceType;
	}

	public void setProvinceType(AddressProvinceType provinceType)
	{
		this.provinceType = provinceType;
	}

	public AddressCityType getCityType()
	{
		return cityType;
	}

	public void setCityType(AddressCityType cityType)
	{
		this.cityType = cityType;
	}

	public int getStatureMax()
	{
		return statureMax;
	}

	public void setStatureMax(int statureMax)
	{
		this.statureMax = statureMax;
	}

	public int getStatureMin()
	{
		return statureMin;
	}

	public void setStatureMin(int statureMin)
	{
		this.statureMin = statureMin;
	}

	public ClaimEducationType getEducationClaim()
	{
		return educationClaim;
	}

	public void setEducationClaim(ClaimEducationType educationClaim)
	{
		this.educationClaim = educationClaim;
	}

	public ClaimMonthlyIncomeType getMonthlyIncomeMin()
	{
		return monthlyIncomeMin;
	}

	public void setMonthlyIncomeMin(ClaimMonthlyIncomeType monthlyIncomeMin)
	{
		this.monthlyIncomeMin = monthlyIncomeMin;
	}

	public ClaimMonthlyIncomeType getMonthlyIncomeMax()
	{
		return monthlyIncomeMax;
	}

	public void setMonthlyIncomeMax(ClaimMonthlyIncomeType monthlyIncomeMax)
	{
		this.monthlyIncomeMax = monthlyIncomeMax;
	}

}
