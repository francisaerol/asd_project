package custom.credit.transactions;

import java.util.Date;

import framework.command.Transaction;
import framework.factory.account.Account;

public class Deposit implements Transaction {

	private Account acct;
	private Double payment;
	private Double balance;
	private Date timeStamp;

	public Deposit(Account acct, double payment) {
		this.acct = acct;
		this.payment = payment;
	}

	@Override
	public void execute() {
		balance = acct.getBalance();
		balance += payment;
		acct.setBalance(balance);
		timeStamp = new Date();
	}

	@Override
	public void unexecute() {
		balance = acct.getBalance();
		balance -= payment;
		acct.setBalance(balance);
	}

	@Override
	public String getTimeStamp() {
		return timeStamp.toString();
	}

}
