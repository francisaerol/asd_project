package framework.control;

import framework.model.ICustomerFactory;

public abstract class FactoryMaker {

	public static ICustomerFactory getCustomerFactory() {
		return new CustomerFactory();
	}

}
