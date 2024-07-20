package com.samanecorp.secureapp.service;

import java.util.List;
import java.util.Optional;

import com.samanecorp.secureapp.dao.AccountUserDao;
import com.samanecorp.secureapp.dao.InterfaceAccountUserDao;
import com.samanecorp.secureapp.dto.AccountUserDto;
import com.samanecorp.secureapp.entities.AccountUserEntity;
import com.samanecorp.secureapp.mapper.AccountUserMapper;


public class AccountUserService implements InterfaceAccountUserService {
	
	private InterfaceAccountUserDao accountUserDao = new AccountUserDao();

	
	
	@Override
	public Optional<AccountUserDto> login(String email, String password) {
		
		if(email.isBlank() || password.isBlank()) {
			return Optional.empty();
		}
		else {
			return testLogin(email, password);
		}
	}

	private Optional<AccountUserDto> testLogin(String email, String password) {
		
		/*
		 * Optional<AccountUserEntity> accountUserEntity = accountUserDao.login(email,
		 * password);
		 * 
		 * if(accountUserEntity.isPresent()) { AccountUserDto accountUserDto =
		 * AccountUserMapper.toAccountUserDto(accountUserEntity.get()); return
		 * Optional.of(accountUserDto); } else { return Optional.empty(); }
		 */
		return  accountUserDao.login(email, password)
							  .map(user -> Optional.of(AccountUserMapper.toAccountUserDto(user)))
							  .orElse(Optional.empty());
	}
	


	@Override
	public Optional<List<AccountUserDto>> findAll() {
		List<AccountUserEntity> accountUserEntityList = accountUserDao.list(new AccountUserEntity());
		
		return Optional.of(AccountUserMapper.toListAccountUserDto(accountUserEntityList));
	}

	public void setAccountUserDao(InterfaceAccountUserDao accountUserDao) {
		this.accountUserDao = accountUserDao;
	}

	@Override
	public boolean save(AccountUserDto accountUserDto) {
		return accountUserDao.save(AccountUserMapper.toAccountUserEntity(accountUserDto));
	}

	@Override
	public Optional<AccountUserDto> signUp(String email, String password){
		
			Optional<AccountUserEntity> accountUserEntity = accountUserDao.signUp(email,password);
		
			if (accountUserEntity.isPresent()) {

		    	return Optional.of(AccountUserMapper.toAccountUserDto(accountUserEntity.get()));

		    }else {
		        return Optional.empty();
		    }	    	
		
		}
	

}
