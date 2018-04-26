package com.qa.business.service;

import javax.inject.Inject;

import com.qa.business.repository.IAccountRepository;

public class AccountService implements IAccountService {

	@Inject
	private IAccountRepository repo;
	
	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String getAnAccount(Long id) {
		return repo.getAnAccount(id);
	}

	@Override
	public String createAnAccount(String accountJSON) {
		return repo.createAnAccount(accountJSON);
	}

	@Override
	public String deleteAnAccount(Long id) {
		return repo.deleteAnAccount(id);
	}

}
