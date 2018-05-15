package com.goleee.luck.service.account.domain;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "accounts")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account
{

	@Id
	private String name;

	private Date lastSeen;

	private String nickname;
	
	private String email;
	
	@Length(min = 0, max = 20)
	private String note;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getLastSeen()
	{
		return lastSeen;
	}

	public void setLastSeen(Date lastSeen)
	{
		this.lastSeen = lastSeen;
	}


	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}
}
