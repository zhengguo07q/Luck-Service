package com.goleee.luck.service.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.goleee.luck.service.auth.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>
{

}
