package com.samanecorp.secureapp.dao;

import java.util.Optional;

import com.samanecorp.secureapp.entities.AccountUserEntity;

public interface InterfaceAccountUserDao extends InterfaceRepository<AccountUserEntity>{
	
	Optional<AccountUserEntity> login(String email, String password);
	
	Optional<AccountUserEntity> signUp(String email, String password);



}
