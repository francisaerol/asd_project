package custom.credit.factory;

import framework.factory.account.IAccountFactory;
import framework.factory.customer.FactoryMaker;

public class CreditAccountFactoryMaker extends FactoryMaker {

	public static IAccountFactory getCreditAccountFactory() {
		return new CreditAccountFactory();
	}

}
