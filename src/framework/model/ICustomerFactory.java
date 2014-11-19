/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package framework.model;

import java.util.Date;

public interface ICustomerFactory {

	public Customer createCompanyCustomer(String name, String email,
			Integer noOfEmployees);

	public Customer createPersonalCustomer(String name, String email,
			Date birthdate);

	public ICustomer createPersonalCustomer(String name, String email);
}
