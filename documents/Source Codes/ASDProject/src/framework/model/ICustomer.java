package framework.model;

import java.util.List;

public interface ICustomer {

	public String getName();

	public String getEmail();

	public List<IAddress> getAddress();

	public Account getAccount(String acctNumber);

	public void addAddress(String street, String city, String state, String zip);

	public void addAccount(Account acct);

}
