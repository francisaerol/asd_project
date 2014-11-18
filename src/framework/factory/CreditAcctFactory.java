package framework.factory;

import framework.factory.customer.IAccount;
import framework.factory.customer.ICustomer;

public class CreditAcctFactory implements IAccountFactory {

	@Override
	public IAccount createAccount(ICustomer cust) {
		return null;
	}

}
