package com.goleee.luck.service.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.goleee.luck.service.auth.domain.User;
import com.goleee.luck.service.auth.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{

	private final Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 密码解码器， 用SPRING提供的
	 */
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	private UserRepository repository;

	@Override
	public void create(User user)
	{

		User existing = repository.findOne(user.getUsername());
		Assert.isNull(existing, "user already exists: " + user.getUsername());

		String hash = encoder.encode(user.getPassword());
		user.setPassword(hash);

		repository.save(user);

		log.info("new user has been created: {}", user.getUsername());
	}
}
