package banking.accounts.type;

import framework.manager.AccountManager;
import framework.model.Account;

public class Savings extends Account {

	public Savings(Double balance, Double interest) {
		super(balance, interest);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setManager(AccountManager mnr) {
		// TODO Auto-generated method stub
		
	}

}
