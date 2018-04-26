package com.qa.business.service;

public interface IAccountService {

	String getAllAccounts();
	String getAnAccount(Long id);
	String createAnAccount(String accountJSON);
	String deleteAnAccount(Long id);
	
}
