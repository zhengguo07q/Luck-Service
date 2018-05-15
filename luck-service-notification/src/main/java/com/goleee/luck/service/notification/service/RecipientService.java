package com.goleee.luck.service.notification.service;

import java.util.List;

import com.goleee.luck.service.notification.domain.NotificationType;
import com.goleee.luck.service.notification.domain.Recipient;

public interface RecipientService
{

	/**
	 * 通过账户名查找邮件地址
	 * 
	 * @param accountName
	 * @return
	 */
	Recipient findByAccountName(String accountName);

	/**
	 * 根据通知类型查找所有相关的邮件地址
	 *
	 * @param type
	 * @return recipients to notify
	 */
	List<Recipient> findReadyToNotify(NotificationType type);

	/**
	 * 给特定人创建邮件地址
	 *
	 * @param accountName
	 * @param recipient
	 * @return updated recipient
	 */
	Recipient save(String accountName, Recipient recipient);

	/**
	 * 设置这个邮件接收者的特定类型的最后一次接收时间， 也就是标记发送过了邮件
	 *
	 * @param type
	 * @param recipient
	 */
	void markNotified(NotificationType type, Recipient recipient);
}
