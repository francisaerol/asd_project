package creditcard.accounts;

import framework.control.FactoryMaker;

public class CreditCardFactoryMaker extends FactoryMaker {
	public static CreditCardAccountFactory getCreditCardFactory() {
		return new CreditCardAccountFactory();
	}
}
