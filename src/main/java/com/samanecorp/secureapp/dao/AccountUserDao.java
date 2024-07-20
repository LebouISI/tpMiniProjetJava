package com.samanecorp.secureapp.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.samanecorp.secureapp.entities.AccountUserEntity;

public class AccountUserDao extends Repository<AccountUserEntity> implements InterfaceAccountUserDao{

	@Override
	public Optional<AccountUserEntity> login(String email, String password) {
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<AccountUserEntity> cr = cb.createQuery(AccountUserEntity.class);
		Root<AccountUserEntity> user = cr.from(AccountUserEntity.class);
		//Predicate pour la clause where
		Predicate predicateEmail = cb.equal(user.get("email"), email);
		Predicate predicatePwd = cb.equal(user.get("password"), password);
		Predicate finalPredicate = cb.and(predicateEmail, predicatePwd);
		
		cr.select(user);
		cr.where(finalPredicate);
		
		return Optional.ofNullable(session.createQuery(cr).getSingleResult());
	}
	
	
	@Override
	public Optional<AccountUserEntity> signUp(String email, String password) {
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<AccountUserEntity> cr = cb.createQuery(AccountUserEntity.class);
	    Root<AccountUserEntity> user = cr.from(AccountUserEntity.class);
	    
	    Predicate predicateEmail = cb.equal(user.get("email"), email);
	    cr.select(user);
	    cr.where(predicateEmail);
	    
	    List<AccountUserEntity> results = session.createQuery(cr).getResultList();
	    
	    if (results.isEmpty()) {
	        return Optional.empty();
	    } else {
	        return Optional.of(results.get(0));
	    }
	    
	    //return Optional.ofNullable(session.createQuery(cr).getSingleResult());
	    
	}

}
