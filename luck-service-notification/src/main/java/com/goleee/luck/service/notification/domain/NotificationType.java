package com.goleee.luck.service.notification.domain;

/**
 * 邮件的通知类型
 * 
 * @author zg
 *
 */
public enum NotificationType
{

	BACKUP("backup.email.subject", "backup.email.text", "backup.email.attachment"), REMIND("remind.email.subject",
			"remind.email.text", null);

	/**
	 * 主题
	 */
	private String subject;

	/**
	 * 内容
	 */
	private String text;

	/**
	 * 附件
	 */
	private String attachment;

	NotificationType(String subject, String text, String attachment)
	{
		this.subject = subject;
		this.text = text;
		this.attachment = attachment;
	}

	public String getSubject()
	{
		return subject;
	}

	public String getText()
	{
		return text;
	}

	public String getAttachment()
	{
		return attachment;
	}
}
