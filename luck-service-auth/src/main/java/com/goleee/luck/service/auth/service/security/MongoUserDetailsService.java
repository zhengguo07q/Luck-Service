package com.goleee.luck.service.auth.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.goleee.luck.service.auth.domain.User;
import com.goleee.luck.service.auth.repository.UserRepository;

@Service
public class MongoUserDetailsService implements UserDetailsService
{

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{

		User user = repository.findOne(username);

		if (user == null)
		{
			throw new UsernameNotFoundException(username);
		}

		return user;
	}
}
