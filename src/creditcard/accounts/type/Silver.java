package creditcard.accounts.type;

import framework.model.Account;
import framework.model.ICustomer;

public class Silver extends Account {

	public Silver(Double balance, Double interest, ICustomer customer) {
		super(balance, interest, customer);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
