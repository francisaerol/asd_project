/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package framework.factory.customer;

import java.util.ArrayList;
import java.util.List;

import framework.factory.account.Account;

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
}
