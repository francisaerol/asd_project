package custom.credit;

import custom.credit.account_types.Gold;
import custom.credit.factory.CreditAccountFactory;
import custom.credit.factory.CreditAccountFactoryMaker;
import custom.credit.transactions.Deposit;
import framework.command.TransactionManager;
import framework.factory.customer.FactoryMaker;
import framework.factory.customer.ICompany;
import framework.factory.customer.ICustomerFactory;

public class CCard {
	public static void main(String[] args) {
		ICustomerFactory custFac = FactoryMaker.getCustomerFactory();

		ICompany company = custFac.createCompanyCustomer("comapny", "asdas",
				123);
		company.addAddress("1000 N 4th St MUM MR 667", "Fairifield", "IA",
				"52557");

		System.out.println(company.getName());

		CreditAccountFactory creditAccountFactory = (CreditAccountFactory) CreditAccountFactoryMaker
				.getCreditAccountFactory();
		creditAccountFactory.setAccountCustomer(company);

		Gold goldAccount = creditAccountFactory.createGoldAccount(5000, 5000);
		TransactionManager tm = new TransactionManager();
		tm.exeuteTransaction(new Deposit(goldAccount, 2000));
		System.out.println(goldAccount.getBalance());
		tm.undoTransaction();
		System.out.println(goldAccount.getBalance());
		System.out.println(goldAccount.getId());

		

	}
}
