package com.goleee.luck.service.notification.domain;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * 邮件接收者
 * 
 * @author zg
 *
 */
@Document(collection = "recipients")
public class Recipient
{

	/**
	 * 账户名
	 */
	@Id
	private String accountName;

	/**
	 * 邮件接收地址
	 */
	@NotNull
	@Email
	private String email;

	@Valid
	private Map<NotificationType, NotificationSettings> scheduledNotifications;

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Map<NotificationType, NotificationSettings> getScheduledNotifications()
	{
		return scheduledNotifications;
	}

	public void setScheduledNotifications(Map<NotificationType, NotificationSettings> scheduledNotifications)
	{
		this.scheduledNotifications = scheduledNotifications;
	}

	@Override
	public String toString()
	{
		return "Recipient{" + "accountName='" + accountName + '\'' + ", email='" + email + '\'' + '}';
	}
}
