package com.qa.persistence.domain;

import javax.persistence.*;

@Entity
public class Account {

		//attributes
		@Id
		@GeneratedValue
		private Long id;
		private String firstName;
		private String lastName;
		private Integer accountNumber;
		
		//constructors
		public Account() {
		}
		
		public Account(String firstName, String lastName, Integer accountNumber) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.accountNumber = accountNumber;
		}

		//getters and setters
		public Long getId() {
			return id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Integer getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(Integer accountNumber) {
			this.accountNumber = accountNumber;
		}
}
