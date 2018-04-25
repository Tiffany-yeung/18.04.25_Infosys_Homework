package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.service.IAccountService;

@Path("/account")
public class AccountEndpoint {
		//instance variable
		@Inject
		private IAccountService service;
		
		//activate the method
		@GET
		@Path("/json")
		@Produces ("application/json")
		public String getAllMovies() {
			return service.getAllAccounts();
		//returns JSON string, and shows it in PostMan
		}
}
