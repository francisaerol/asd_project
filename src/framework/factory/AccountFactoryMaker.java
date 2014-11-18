/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package framework.factory;

/**
 *
 * @author Adit
 */
public class AccountFactoryMaker {

	public enum Type {
		CREDIT, COMPANY, PERSONAL
	};

	public static ICustomerFactory getICustomerFactory() {

		return new CustomerFactory();
	}

	public static IAccountFactory getAccountFactory(Type type) {
		IAccountFactory factory = null;
		switch (type) {
		case CREDIT:
			factory = new CreditAcctFactory();
			break;
		case COMPANY:
			factory = new CompanyAcctFactory();
			break;
		case PERSONAL:
			factory = new PersonalAcctFactory();
			break;
		}
		return factory;
	}
}
