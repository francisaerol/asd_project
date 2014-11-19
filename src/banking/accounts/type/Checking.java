package banking.accounts.type;

import framework.manager.AccountManager;
import framework.model.Account;
import framework.model.ICustomer;

public class Checking extends Account {

	public Checking(Double balance, Double interest,ICustomer cust) {
		super(balance, interest, cust);
	}

	@Override
	public void update() {
		Double newInterest = (Double) super.getAccountManager().getElement();
		super.setInterest(newInterest);
	}


}
