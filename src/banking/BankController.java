package banking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.UIManager;

import banking.accounts.BankAccountFactory;
import banking.accounts.BankFactoryMaker;
import framework.control.FactoryMaker;
import framework.control.IController;
import framework.control.command.Deposit;
import framework.control.command.TransactionManager;
import framework.control.command.TransactionTypes;
import framework.control.command.Withdraw;
import framework.model.Account;
import framework.model.IAccountFactory;
import framework.model.ICustomer;
import framework.model.ICustomerFactory;
import framework.view.bank.BankFrm;
import framework.view.bank.IFrame;

public class BankController implements IController {

	private IFrame jframe;
	private ICustomer cust;
	private TransactionManager tm;
	private Account acct;
	private ICustomerFactory customerFactory = FactoryMaker
			.getCustomerFactory();
	private BankAccountFactory af = BankFactoryMaker.getBankAccountFactory();

	@Override
	public IFrame getFrame() {
		// TODO Auto-generated method stub
		return jframe;
	}

	@Override
	public void setIFrame(IFrame jframe) {
		this.jframe = jframe;

		this.jframe.setController(this);

		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			// Create a new instance of our application's frame, and make it
			// visible.
			this.jframe.setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}

	}

	@Override
	public void transact(TransactionTypes type, String acctNumber, Double value) {
		acct = cust.getAccount(acctNumber);
		if (acct != null) {
			switch (type) {
			case ADD_INTEREST:
				// tm.exeuteTransaction(new AddInterest(value));
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
	public void addCustomer(String[] row) {
		System.out.println("==============");
		String[] details = (String[]) row;

		/*
		 * 1 - name 2 - st 3 - city 4 - state 5 - zip 6 - birthdate /
		 * noOfEmployess 7 - email 8 - P or C 9 - S or Ch 10 - amount
		 */

		if (details[8] == "P") {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			Date bdate = null;
			try {
				bdate = formatter.parse(details[6]);
			} catch (ParseException e) {

			}
			cust = customerFactory.createPersonalCustomer(details[1],
					details[7], bdate);
			cust.addAddress(details[2], details[3], details[4], details[5]);

		} else {
			cust = customerFactory.createCompanyCustomer(details[1],
					details[6], Integer.parseInt(details[7]));
			cust.addAddress(details[2], details[3], details[4], details[5]);
		}
		af.setAccountCustomer(cust);
		if (details[9] == "S") {

			acct = af.createSavingsAccount(0, 0);
		} else {
			acct = af.createCheckingAccount(0, 0);
		}

		System.out.println("XXXXXXXXXXXXXXXXXXXXXX: " + cust.getName());
	}

	@Override
	public String getAcctNo() {
		// TODO Auto-generated method stub
		return acct.getId();
	}

}
