package framework.manager;

import java.util.ArrayList;
import java.util.List;

import framework.model.Account;
import framework.model.ICustomer;

public class AccountManager {
	private static List<ICustomer> customerList;
	private static List<Account> accountList;
	private static AccountManager _instance;
	private Object element;

	private int id = 1000;

	private AccountManager() {
		// singleton
	}

	public static AccountManager getInstance() {
		if (_instance == null) {
			_instance = new AccountManager();
			customerList = new ArrayList<ICustomer>();
			accountList = new ArrayList<Account>();
		}
		return _instance;
	}

	public void addCustomer(ICustomer cust) {
		customerList.add(cust);
	}

	public void addAccount(Account acct) {
		accountList.add(acct);
	}

	public Account getAccount(String acctID) {
		for (Account acc : accountList) {
			if (acc.getId() == acctID) {
				return acc;
			}
		}
		return null;
	}

	public String getNewId() {
		id++;
		return String.valueOf(id);
	}

	public void notifyAllObservers(Object element) {
		this.element = element;
		for (Account a : accountList) {
			a.update();
			System.out.println("Interest: " + a.getInterest());
		}
	}

	public Object getElement() {
		return element;
	}

	public List<Account> getAccountList() {
		return accountList;
	}
}
