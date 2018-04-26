package com.qa.business.repository;

public interface IAccountRepository {

	String getAllAccounts();
	String getAnAccount(Long id);
	String createAnAccount(String accountJSON);
	String deleteAnAccount(Long id);
	String updateAnAccount(String accountCorrection);
	
}
