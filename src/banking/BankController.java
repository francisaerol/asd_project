package banking;

import framework.control.IController;
import framework.control.command.AddInterest;
import framework.control.command.Deposit;
import framework.control.command.TransactionManager;
import framework.control.command.TransactionTypes;
import framework.control.command.Withdraw;
import framework.model.Account;
import framework.model.ICustomer;
import framework.view.bank.IFrame;

public class BankController implements IController {

	private IFrame jframe;
	private ICustomer cust;
	private TransactionManager tm;
	private Account acct;

	@Override
	public IFrame getFrame() {
		// TODO Auto-generated method stub
		return jframe;
	}

	@Override
	public void setIFrame(IFrame jframe) {
		this.jframe = jframe;
		jframe.setVisible(true);
		jframe.setController(this);

	}

	@Override
	public void transact(TransactionTypes type, String acctNumber, Double value) {
		acct = cust.getAccount(acctNumber);
		if (acct != null) {
			switch (type) {
			case ADD_INTEREST:
//				tm.exeuteTransaction(new AddInterest(value));
				break;
			case WITHDRAW:
				value = -value;
				tm.exeuteTransaction(new Withdraw(acct, value));
				break;
			case DEPOSIT:
				tm.exeuteTransaction(new Deposit(acct, value));
				break;
			default:
				
				break;
			}
		}

	}


	@Override
	public void addCustomer(String[] details) {
		// TODO Auto-generated method stub

	}


}
