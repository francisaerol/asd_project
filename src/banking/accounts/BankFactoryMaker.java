package banking.accounts;

import framework.control.FactoryMaker;

public class BankFactoryMaker extends FactoryMaker {
	public static BankAccountFactory getBankAccountFactory() {
		return new BankAccountFactory();
	}
}
