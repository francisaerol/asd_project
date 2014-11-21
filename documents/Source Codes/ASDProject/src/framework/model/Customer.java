package framework.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer implements ICustomer {
	private String name;
	private List<IAddress> addressList;
	private List<Account> acctList;
	private String email;

	protected Customer(String name, String email) {
		this.name = name;
		this.email = email;
		addressList = new ArrayList<IAddress>();
		acctList = new ArrayList<Account>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<IAddress> getAddress() {
		return addressList;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void addAddress(String street, String city, String state, String zip) {
		addressList.add(new Address(street, city, zip, state));
	}

	@Override
	public void addAccount(Account acct) {
		acctList.add(acct);
	}

	@Override
	public Account getAccount(String acctNumber) {
		Iterator<Account> accIter = acctList.iterator();
		while (accIter.hasNext()) {
			Account a = accIter.next();
			if (a.getId() == acctNumber) {
				return a;
			}
		}
		return null;
	}
}
