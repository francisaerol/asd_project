package creditcard;

import java.util.Date;

import framework.control.command.Transaction;
import framework.model.Account;

public class chargeTheAccount implements Transaction {
	private Date timeStamp;
	private Account acct;
	private Double amount;

	public chargeTheAccount(Account acct, Double value) {
		this.acct = acct;
		this.amount = value;
		timeStamp = new Date();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTimeStamp() {
		// TODO Auto-generated method stub
		return null;
	}

}
