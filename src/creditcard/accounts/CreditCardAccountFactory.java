package creditcard.accounts;

import creditcard.accounts.type.Bronze;
import creditcard.accounts.type.Gold;
import creditcard.accounts.type.Silver;

import framework.model.IAccountFactory;
import framework.model.ICustomer;

public class CreditCardAccountFactory implements IAccountFactory {
	private ICustomer customer;

	@Override
	public void setAccountCustomer(ICustomer customer) {
		this.customer = customer;
	}

	public Gold createGoldAccout(Double balance, Double interest) {
		Gold g = new Gold(balance, interest, customer);
		customer.addAccount(g);
		return g;
	}

	public Silver createSilverAccount(Double balance, Double interest) {
		Silver s = new Silver(balance, interest, customer);
		customer.addAccount(s);
		return s;
	}

	public Bronze createBronzeAccount(Double balance, Double interest) {
		Bronze b = new Bronze(balance, interest, customer);
		customer.addAccount(b);
		return b;
	}

}
