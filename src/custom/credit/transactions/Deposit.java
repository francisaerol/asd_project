package custom.credit.transactions;

import framework.command.Transaction;
import framework.factory.account.Account;

public class Deposit implements Transaction {

	private Account acct;
	private Double payment;
	private Double balance;

	public Deposit(Account acct, double payment) {
		this.acct = acct;
		this.payment = payment;
	}

	@Override
	public void execute() {
		balance = acct.getBalance();
		balance += payment;
		acct.setBalance(balance);
	}

	@Override
	public void unexecute() {
		balance = acct.getBalance();
		balance -= payment;
		acct.setBalance(balance);
	}

}
