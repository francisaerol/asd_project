package framework.manager;

import java.util.LinkedList;
import java.util.List;

import framework.factory.customer.IAccount;

public class AccountManager {
	private static List<IAccount> accountList;
	private static AccountManager _instance;

	private AccountManager() {
		// singleton
	}

	public static AccountManager getInstance() {
		if (_instance == null) {
			_instance = new AccountManager();
			accountList = new LinkedList<IAccount>();
		}
		return _instance;
	}

	public void addAccount(IAccount acct) {
		accountList.add(acct);
	}

}
