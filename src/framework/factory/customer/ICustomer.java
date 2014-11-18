package framework.factory.customer;

import java.util.List;

import framework.factory.account.Account;

public interface ICustomer {

	public String getName();

	public List<IAddress> getAddress();

	public String getEmail();

	public void addAddress(String street, String city, String state, String zip);

	public void addAccount(Account acct);

}
