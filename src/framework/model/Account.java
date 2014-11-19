package framework.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import framework.manager.AccountManager;

public abstract class Account implements IAccount {

	private Double interest;
	private String id;
	private AccountManager accountManager = AccountManager.getInstance();
	private List<Entry> entries;
	private ICustomer customer;

	public Account(Double balance, Double interest, ICustomer customer) {
		entries = new ArrayList<Entry>();
		entries.add(new Entry(balance, new Date()));
		this.interest = interest;
		this.id = getAccountManager().getNewId();
		this.customer = customer;
	}

	public String getCustomerFlag() {
		if (customer instanceof PersonalCustomer) {
			return "P";
		}
		return "C";
	}

	public ICustomer getCustomer() {
		return customer;
	}

	@Override
	public Double getBalance() {
		double balance = 0;
		Iterator<Entry> entryIter = entries.iterator();
		while (entryIter.hasNext()) {
			Entry e = entryIter.next();
			balance += e.getValue();
		}
		return balance;
	}

	public void addNewEntry(Double value) {
		entries.add(new Entry(value, new Date()));
	}

	@Override
	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	@Override
	public String getId() {
		return id;
	}

	public AccountManager getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	public List<Entry> getEntries() {
		return entries;
	}

}
