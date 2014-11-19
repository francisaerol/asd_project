package creditcard;

import framework.model.Account;
import framework.model.IAccount;
import framework.model.ICustomer;

public class CreditCardFactory implements IAccount {
	private ICustomer iCustomer;

	

	public ICustomer getiCustomer() {
		return iCustomer;
	}

	public void setiCustomer(ICustomer iCustomer) {
		this.iCustomer = iCustomer;
	}

	@Override
	public Double getBalance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getInterest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
	public Gold createGoldAccounts(double i, double d) {
		Gold gAcc = new Gold(i, d, iCustomer);
		return gAcc;
	}
}
