package custom.credit.products;

import framework.factory.customer.IAccount;

public class Gold implements IAccount {

	@Override
	public double getInterest() {
		return 20;
	}

}
