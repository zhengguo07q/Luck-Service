package com.goleee.luck.service.account.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.goleee.luck.service.account.client.AuthServiceClient;
import com.goleee.luck.service.account.client.StatisticsServiceClient;
import com.goleee.luck.service.account.domain.Account;
import com.goleee.luck.service.account.domain.User;
import com.goleee.luck.service.account.repository.AccountRepository;

public class AccountServiceTest
{

	@InjectMocks
	private AccountServiceImpl accountService;

	@Mock
	private StatisticsServiceClient statisticsClient;

	@Mock
	private AuthServiceClient authClient;

	@Mock
	private AccountRepository repository;

	@Before
	public void setup()
	{
		initMocks(this);
	}

	@Test
	public void shouldFindByName()
	{

		final Account account = new Account();
		account.setName("test");

		when(accountService.findByName(account.getName())).thenReturn(account);
		Account found = accountService.findByName(account.getName());

		assertEquals(account, found);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenNameIsEmpty()
	{
		accountService.findByName("");
	}

	@Test
	public void shouldCreateAccountWithGivenUser()
	{

		User user = new User();
		user.setUsername("test");

		Account account = accountService.create(user);

		assertEquals(user.getUsername(), account.getName());
		assertNotNull(account.getLastSeen());

		verify(authClient, times(1)).createUser(user);
		verify(repository, times(1)).save(account);
	}

	@Test
	public void shouldSaveChangesWhenUpdatedAccountGiven()
	{


		final Account update = new Account();
		update.setName("test");
		update.setNote("test note");
		final Account account = new Account();

		when(accountService.findByName("test")).thenReturn(account);
		accountService.saveChanges("test", update);

		assertEquals(update.getNote(), account.getNote());
		assertNotNull(account.getLastSeen());


		verify(repository, times(1)).save(account);
		verify(statisticsClient, times(1)).updateStatistics("test", account);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenNoAccountsExistedWithGivenName()
	{
		final Account update = new Account();

		when(accountService.findByName("test")).thenReturn(null);
		accountService.saveChanges("test", update);
	}
}
