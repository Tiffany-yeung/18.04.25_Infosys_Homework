package com.qa.business.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountDatabaseRepository implements IAccountRepository {

	private static final Logger LOGGER = Logger.getLogger(AccountDatabaseRepository.class);
	//static and final because we only want one instance of it
	//same logger class in every application
	//gives us a way to write stuff in our logs
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	//converting objects to JSON and vice versa
	
	@Override
	public String getAllAccounts() {
		LOGGER.info("AccountDatabaseRepository getAllAccounts");
		//class name, then method
		//construct query
		Query query = manager.createQuery("Select a FROM Account a"); //a=alias
		//executes query
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		//convert it to JSON
		return util.getJSONForObject(accounts);
	}

	private Account findAnAccount(Long id) {
		return manager.find(Account.class, id);
	}
	
	@Override
	public String getAnAccount(Long id) {
		Account account = findAnAccount(id);
		if(account!=null) {
			return util.getJSONForObject(account);
		}
		else {
			return "{\"message\":\"account not found\"}";
		}
	}

	@Override
	@Transactional(REQUIRED)
	public String createAnAccount(String accountJSON) {
		Account account = util.getObjectForJSON(accountJSON, Account.class);
		manager.persist(account);
		return "{\"message\":\"account created\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAnAccount(Long id) {
		Account accountToDelete = findAnAccount(id);
		if(accountToDelete != null) {
			manager.remove(accountToDelete);
			return "{\"message\":\"account deleted\"}";
		}
		else {
			return "{\"message\":\"account not found, cannot be deleted\"}";
		}
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAnAccount(String accountCorrection) {
		Account correctAccount = util.getObjectForJSON(accountCorrection, Account.class);
		Account wrongAccount = findAnAccount(correctAccount.getId());
		if(wrongAccount != null) {
			manager.merge(correctAccount);
			return "{\"message\":\"account updated\"}";
		}
		else {
			return "{\"message\":\"account not found, cannot update\"}";
		}
	}


}
