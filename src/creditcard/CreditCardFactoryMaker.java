package creditcard;

import framework.control.FactoryMaker;

public class CreditCardFactoryMaker extends FactoryMaker {
	public static CreditCardFactory getCreditCardFactory() {
		return new CreditCardFactory();
	}
}
