package creditcard.accounts;

import creditcard.accounts.type.Bronze;
import creditcard.accounts.type.Gold;
import creditcard.accounts.type.Silver;

import framework.model.IAccountFactory;
import framework.model.ICustomer;

public class CreditCardAccountFactory implements IAccountFactory {
	private ICustomer iCustomer;

	@Override
	public void setAccountCustomer(ICustomer customer) {
		this.iCustomer = customer;
	}

	public Gold createGoldAccout(Double balance, Double interest) {
		return new Gold(balance, interest, iCustomer);
	}

	public Silver createSilverAccount(Double balance, Double interest) {
		return new Silver(balance, interest, iCustomer);
	}

	public Bronze createBronzeAccount(Double balance, Double interest) {
		return new Bronze(balance, interest, iCustomer);
	}

}
