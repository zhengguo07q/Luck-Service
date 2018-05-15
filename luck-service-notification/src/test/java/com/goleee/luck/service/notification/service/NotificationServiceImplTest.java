package com.goleee.luck.service.notification.service;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.IOException;

import javax.mail.MessagingException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.goleee.luck.service.notification.client.AccountServiceClient;
import com.goleee.luck.service.notification.domain.NotificationType;
import com.goleee.luck.service.notification.domain.Recipient;
import com.goleee.luck.service.notification.service.EmailService;
import com.goleee.luck.service.notification.service.NotificationServiceImpl;
import com.goleee.luck.service.notification.service.RecipientService;
import com.google.common.collect.ImmutableList;

public class NotificationServiceImplTest
{

	@InjectMocks
	private NotificationServiceImpl notificationService;

	@Mock
	private RecipientService recipientService;

	@Mock
	private AccountServiceClient client;

	@Mock
	private EmailService emailService;

	@Before
	public void setup()
	{
		initMocks(this);
	}

	@Test
	public void shouldSendBackupNotificationsEvenWhenErrorsOccursForSomeRecipients()
			throws IOException, MessagingException, InterruptedException
	{

		final String attachment = "json";

		Recipient withError = new Recipient();
		withError.setAccountName("with-error");

		Recipient withNoError = new Recipient();
		withNoError.setAccountName("with-no-error");

		when(client.getAccount(withError.getAccountName())).thenThrow(new RuntimeException());
		when(client.getAccount(withNoError.getAccountName())).thenReturn(attachment);

		when(recipientService.findReadyToNotify(NotificationType.BACKUP))
				.thenReturn(ImmutableList.of(withNoError, withError));

		notificationService.sendBackupNotifications();

		// TODO test concurrent code in a right way

		verify(emailService, timeout(100)).send(NotificationType.BACKUP, withNoError, attachment);
		verify(recipientService, timeout(100)).markNotified(NotificationType.BACKUP, withNoError);

		verify(recipientService, never()).markNotified(NotificationType.BACKUP, withError);
	}

	@Test
	public void shouldSendRemindNotificationsEvenWhenErrorsOccursForSomeRecipients()
			throws IOException, MessagingException, InterruptedException
	{

		final String attachment = "json";

		Recipient withError = new Recipient();
		withError.setAccountName("with-error");

		Recipient withNoError = new Recipient();
		withNoError.setAccountName("with-no-error");

		when(recipientService.findReadyToNotify(NotificationType.REMIND))
				.thenReturn(ImmutableList.of(withNoError, withError));
		doThrow(new RuntimeException()).when(emailService).send(NotificationType.REMIND, withError, null);

		notificationService.sendRemindNotifications();

		// TODO test concurrent code in a right way

		verify(emailService, timeout(100)).send(NotificationType.REMIND, withNoError, null);
		verify(recipientService, timeout(100)).markNotified(NotificationType.REMIND, withNoError);

		verify(recipientService, never()).markNotified(NotificationType.REMIND, withError);
	}
}