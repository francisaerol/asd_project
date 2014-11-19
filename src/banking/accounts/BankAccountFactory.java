package banking.accounts;

import banking.accounts.type.Checking;
import banking.accounts.type.Savings;
import framework.model.IAccountFactory;
import framework.model.ICustomer;

public class BankAccountFactory implements IAccountFactory {
	private ICustomer customer;

	@Override
	public void setAccountCustomer(ICustomer customer) {
		this.customer = customer;
	}

	public Checking createCheckingAccount(double balance, double interest) {
		Checking c = new Checking(balance, interest,customer);
		customer.addAccount(c);
		return c;
	}

	public Savings createSavingsAccount(double balance, double interest) {
		Savings s = new Savings(balance, interest,customer);
		customer.addAccount(s);
		return s;
	}

	public ICustomer getCustomer() {
		return customer;
	}

}
