package com.goleee.luck.service.statistics.domain;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "accounts")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account
{

	@Valid
	@NotNull
	private List<Item> incomes;

	@Valid
	@NotNull
	private List<Item> expenses;

	@Valid
	@NotNull
	private Saving saving;

	public List<Item> getIncomes()
	{
		return incomes;
	}

	public void setIncomes(List<Item> incomes)
	{
		this.incomes = incomes;
	}

	public List<Item> getExpenses()
	{
		return expenses;
	}

	public void setExpenses(List<Item> expenses)
	{
		this.expenses = expenses;
	}

	public Saving getSaving()
	{
		return saving;
	}

	public void setSaving(Saving saving)
	{
		this.saving = saving;
	}
}
