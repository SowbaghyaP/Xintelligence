package com.user.login.loginuser.userdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserJPARepositaory {
	@PersistenceContext
	private EntityManager entityManager;

	public void insert(Users users) {
		entityManager.merge(users);
	}
	
	

}
