package framework.factory.account;

import framework.manager.AccountManager;

public abstract class Account {

	private Double balance;
	private Double interest;
	private String id;
	private AccountManager acm = AccountManager.getInstance();

	public Account(Double balance, Double interest) {
		this.balance = balance;
		this.interest = interest;
		this.id = acm.getNewId();
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double money) {
		this.balance = money;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public String getId() {
		return id;
	}
	
	

}
