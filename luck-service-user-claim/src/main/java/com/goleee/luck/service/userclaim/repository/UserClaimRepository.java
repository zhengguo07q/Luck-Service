package com.goleee.luck.service.userclaim.repository;

import org.springframework.stereotype.Repository;

import com.goleee.luck.service.userclaim.domain.UserClaim;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserClaimRepository extends CrudRepository<UserClaim, String>
{

}
