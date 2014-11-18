package custom.credit;

import java.util.Date;

import framework.factory.AccountFactoryMaker;
import framework.factory.AccountFactoryMaker.Type;
import framework.factory.CreditAcctFactory;
import framework.factory.IAccountFactory;
import framework.factory.customer.Address;
import framework.factory.customer.IAccount;
import framework.factory.customer.IAddress;
import framework.factory.customer.PersonalCustomer;

public class CCard {

	public static void main(String[] args) {
		IAccountFactory ccfac = AccountFactoryMaker
				.getAccountFactory(Type.CREDIT);

	}
}
