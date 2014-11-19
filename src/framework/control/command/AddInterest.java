package framework.control.command;

import java.util.Date;

import framework.manager.AccountManager;

public class AddInterest implements Transaction {

	private Double interest;
	private Date timeStamp;
	private static AccountManager accountManager = AccountManager.getInstance();

	public AddInterest(Double newInterest) {
		this.interest = newInterest;
		timeStamp = new Date();
	}

	@Override
	public void execute() {
		accountManager.notifyAllObservers(interest);
	}

	@Override
	public void unexecute() {

	}

	@Override
	public String getTimeStamp() {
		return timeStamp.toString();
	}

}
