package framework.factory.customer;

public abstract class FactoryMaker {

	public static ICustomerFactory getCustomerFactory() {
		return new CustomerFactory();
	}

}
