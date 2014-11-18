package framework.factory.account;

import framework.factory.customer.ICustomer;

public interface IAccountFactory {
	public void setAccountCustomer(ICustomer customer);
}
