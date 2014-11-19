package framework.control.command;

import java.util.Date;

import framework.model.Account;

public class Withdraw implements Transaction {
	private Date timeStamp;
	private Account acct;
	private Double amount;
	
	
	public Withdraw(Account acct,Double amt) {
		this.acct = acct;
		this.amount = amt;
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
