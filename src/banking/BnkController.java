package banking;

import banking.accounts.BankFactoryMaker;
import framework.model.IAccount;
import framework.model.IAccountFactory;

public class BnkController {
	public IAccount createSavings() {
		IAccountFactory fact = BankFactoryMaker.getBankAccountFactory();
		return null;
	}
}
