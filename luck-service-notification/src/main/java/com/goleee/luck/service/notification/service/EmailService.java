package com.goleee.luck.service.notification.service;

import java.io.IOException;

import javax.mail.MessagingException;

import com.goleee.luck.service.notification.domain.NotificationType;
import com.goleee.luck.service.notification.domain.Recipient;

/**
 * 邮件服务
 * @author zg
 *
 */
public interface EmailService
{
	/**
	 * 发送邮件
	 * 
	 * @param type 发送邮件的类型
	 * @param recipient	发送邮件的邮箱
	 * @param attachment 附件
	 * @throws MessagingException
	 * @throws IOException
	 */
	void send(NotificationType type, Recipient recipient, String attachment) throws MessagingException, IOException;
}
