/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package framework.factory.customer;

import java.util.Date;

public class CustomerFactory implements ICustomerFactory {
	
	protected CustomerFactory(){
	}

	@Override
	public ICompany createCompanyCustomer(String name, String email,
			Integer noOfEmployees) {
		return new Company(name, email, noOfEmployees);
	}

	@Override
	public IPersonal createPersonalCustomer(String name, String email,
			Date birthdate) {
		return new PersonalCustomer(name, email, birthdate);
	}

}
