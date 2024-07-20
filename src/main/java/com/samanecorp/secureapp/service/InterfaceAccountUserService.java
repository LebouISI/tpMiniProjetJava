package com.samanecorp.secureapp.service;

import java.util.List;
import java.util.Optional;

import com.samanecorp.secureapp.dto.AccountUserDto;


public interface InterfaceAccountUserService {
	
	Optional<AccountUserDto> login(String email, String password);
	
	Optional<AccountUserDto> signUp(String email, String password);

	
	Optional<List<AccountUserDto>> findAll();
	
	boolean save(AccountUserDto accountUserDto);

}
