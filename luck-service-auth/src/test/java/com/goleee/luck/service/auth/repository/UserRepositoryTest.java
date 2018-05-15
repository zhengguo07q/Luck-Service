package com.goleee.luck.service.auth.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goleee.luck.service.auth.AuthApplication;
import com.goleee.luck.service.auth.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AuthApplication.class)
public class UserRepositoryTest
{

	@Autowired
	private UserRepository repository;

	@Test
	public void shouldSaveAndFindUserByName()
	{

		User user = new User();
		user.setUsername("name");
		user.setPassword("password");
		repository.save(user);

		User found = repository.findOne(user.getUsername());
		assertEquals(user.getUsername(), found.getUsername());
		assertEquals(user.getPassword(), found.getPassword());
	}
}
