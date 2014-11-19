package banking.accounts.type;

import framework.model.Account;
import framework.model.ICustomer;

public class Savings extends Account {
	public Savings(Double balance, Double interest,ICustomer cust) {
		super(balance, interest, cust);
	}

	@Override
	public void update() {
		Double newInterest = (Double) super.getAccountManager().getElement();
		super.setInterest(newInterest);
	}


}
