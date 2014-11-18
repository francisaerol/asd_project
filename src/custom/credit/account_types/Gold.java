package custom.credit.account_types;

import framework.factory.account.Account;

public class Gold extends Account {

	public Gold(Double balance, Double interest) {
		super(balance, interest);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ":" + this.getId();
	}
}
