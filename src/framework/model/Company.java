package framework.model;

public class Company extends Customer implements ICompany {

	private Integer noOfEmployees;

	public Company(String name, String email, Integer noOfEmployees) {
		super(name, email);
		this.noOfEmployees = noOfEmployees;
	}

	@Override
	public Integer getNoOfEmployees() {
		return noOfEmployees;
	}

}
