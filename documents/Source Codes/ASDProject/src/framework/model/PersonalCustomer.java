package framework.model;

import java.util.Date;

public class PersonalCustomer extends Customer implements IPersonal {

	private Date birthdate;

	public PersonalCustomer(String name, String email, Date birthdate) {
		super(name, email);
		this.birthdate = birthdate;
	}

	public PersonalCustomer(String name, String email) {
		super(name, email);
	}

	@Override
	public Date getBirthdate() {
		return birthdate;
	}

}
