/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package framework.factory.customer;

import java.util.Date;

/**
 *
 * @author Adit
 */
public class PersonalCustomer extends Customer implements IPersonal {

	private Date birthdate;

	protected PersonalCustomer(String name, String email, Date birthdate) {
		super(name, email);
		this.birthdate = birthdate;
	}

	@Override
	public Date getBirthdate() {
		return birthdate;
	}

}