package framework.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import framework.manager.AccountManager;

public abstract class Account implements IAccount {

	private Double interest;
	private String id;
	private AccountManager acm = AccountManager.getInstance();
	private List<Entry> entries;

	public Account(Double balance, Double interest) {
		entries = new ArrayList<Entry>();
		entries.add(new Entry(balance, new Date()));
		this.interest = interest;
		this.id = acm.getNewId();
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

}
