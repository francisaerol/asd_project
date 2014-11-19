package framework.manager;

import java.util.LinkedList;
import java.util.List;

import framework.model.ICustomer;

public class AccountManager {
	private static List<ICustomer> customerList;
	private static AccountManager _instance;

	private int id = 1000;

	private AccountManager() {
		// singleton
	}

	public static AccountManager getInstance() {
		if (_instance == null) {
			_instance = new AccountManager();
			customerList = new LinkedList<ICustomer>();
		}
		return _instance;
	}

	public void addCustomer(ICustomer cust) {
		customerList.add(cust);
	}

	public String getNewId() {
		id++;
		return String.valueOf(id);
	}
	
	public void addInterest(){
	
	}

}
