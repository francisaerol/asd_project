package framework.control.command;

import java.util.Date;

import framework.model.Account;

public class Deposit implements Transaction {
	private Date timeStamp;
	private Account acct;
	private Double amount;

	public Deposit(Account acct, Double amount) {
		this.acct = acct;
		this.amount = amount;
		timeStamp = new Date();
	}

	@Override
	public void execute() {
		acct.addNewEntry(amount);
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTimeStamp() {
		return timeStamp.toString();
	}

}
