package custom.credit.factory;

import custom.credit.account_types.Gold;
import framework.factory.account.Account;
import framework.factory.account.IAccountFactory;
import framework.factory.customer.ICustomer;

public class CreditAccountFactory implements IAccountFactory {

	private ICustomer customer;

	@Override
	public void setAccountCustomer(ICustomer customer) {
		this.customer = customer;
	}

	public Gold createGoldAccount(double money, double interest) {
		Gold g = new Gold(money, interest);
		customer.addAccount(g);
		return g;
	}

	public Account createSilverAccount() {
		return null;
	}

	public Account createBronzeAccount() {
		return null;
	}

}
