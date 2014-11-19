package framework.model;

import java.util.List;

public interface ICustomer {

	public String getName();

	public List<IAddress> getAddress();

	public String getEmail();

	public void addAddress(String street, String city, String state, String zip);

	public void addAccount(Account acct);
	

}
