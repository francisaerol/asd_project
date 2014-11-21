package creditcard.accounts.type;

import framework.model.Account;
import framework.model.ICustomer;

public class Bronze extends Account {
	private Double minimumPayment = 14.0;

	public Bronze(Double balance, Double interest, ICustomer customer) {
		super(balance, 10.0, customer);
	}

	@Override
	public void update() {
		Double newInterest = (Double) super.getAccountManager().getElement();
		super.setInterest(super.getInterest() + newInterest);
	}

	public Double getMinimumPayment() {
		return minimumPayment;
	}
}
