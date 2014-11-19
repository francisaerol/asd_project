/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package framework.control;

import java.util.Date;

import framework.model.Company;
import framework.model.Customer;
import framework.model.ICustomerFactory;
import framework.model.PersonalCustomer;

public class CustomerFactory implements ICustomerFactory {

	protected CustomerFactory() {
	}

	@Override
	public Customer createCompanyCustomer(String name, String email,
			Integer noOfEmployees) {
		return new Company(name, email, noOfEmployees);
	}

	@Override
	public Customer createPersonalCustomer(String name, String email,
			Date birthdate) {
		return new PersonalCustomer(name, email, birthdate);
	}

}
