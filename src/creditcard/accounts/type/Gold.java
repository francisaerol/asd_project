package creditcard.accounts.type;

import framework.model.Account;
import framework.model.ICustomer;

public class Gold extends Account {
	private Double minimumPaymentPercent = 10.0;

	public Gold(Double balance, Double interest, ICustomer customer) {
		super(balance, 6.0, customer);
	}

	@Override
	public void update() {
		Double newInterest = (Double) super.getAccountManager().getElement();
		super.setInterest(super.getInterest() + newInterest);
	}

	public Double getMinimumPaymentPercent() {
		return minimumPaymentPercent;
	}
}
