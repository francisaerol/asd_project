package creditcard;

import java.security.Timestamp;

import framework.model.Account;
import framework.model.ICustomer;

public class Gold extends Account {
	private Timestamp expDate;
	
	public Gold(Double balance, Double interest, ICustomer customer) {
		super(balance, interest, customer);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
}
