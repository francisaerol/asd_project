package creditcard.accounts.type;

import framework.model.Account;
import framework.model.ICustomer;

public class Silver extends Account {
	private Double minimumPaymentPercent = 12.0;

	public Silver(Double balance, Double interest, ICustomer customer) {
		super(balance, 8.0, customer);
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
