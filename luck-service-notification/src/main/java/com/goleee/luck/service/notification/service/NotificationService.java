package com.goleee.luck.service.notification.service;

/**
 * 
 * 
 * @author zg
 *
 */
public interface NotificationService
{
	/**
	 * 定时发送备份邮件
	 */
	void sendBackupNotifications();

	/**
	 * 定时发送通知邮件
	 */
	void sendRemindNotifications();
}
