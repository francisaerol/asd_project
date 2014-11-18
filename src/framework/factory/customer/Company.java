package framework.factory.customer;

import java.util.List;

public class Company extends Customer implements ICompany {

	private Integer noOfEmployees;

	public Company(String name, List<IAddress> addressList, String email,
			IAddress address, Integer noOfEmployees) {
		super(name, email);
		this.noOfEmployees = noOfEmployees;
	}

	@Override
	public Integer getNoOfEmployees() {
		return noOfEmployees;
	}

}
