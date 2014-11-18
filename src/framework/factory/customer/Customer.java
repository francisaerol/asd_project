/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package framework.factory.customer;

import java.util.List;

/**
 *
 * @author Adit
 */
public class Customer implements ICustomer {
	private String name;
	private List<IAddress> addressList;
	private String email;

	public Customer(String name, String email) {
		this.name = name;
		this.email = email;
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
	public void addAddress(IAddress address) {
		addressList.add(address);
	}

}
