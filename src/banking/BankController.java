package banking;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.UIManager;

import banking.accounts.BankAccountFactory;
import banking.accounts.BankFactoryMaker;
import framework.control.FactoryMaker;
import framework.control.IController;
import framework.control.command.AddInterest;
import framework.control.command.Deposit;
import framework.control.command.TransactionManager;
import framework.control.command.TransactionTypes;
import framework.control.command.Withdraw;
import framework.manager.AccountManager;
import framework.model.Account;
import framework.model.ICustomer;
import framework.model.ICustomerFactory;
import framework.view.bank.IFrame;
import framework.view.messages.Message;

public class BankController implements IController {

	private IFrame jframe;
	private ICustomer cust;
	private TransactionManager tm;
	private Account acct;
	private AccountManager acccountManager = AccountManager.getInstance();
	private ICustomerFactory customerFactory = FactoryMaker
			.getCustomerFactory();
	private BankAccountFactory af = BankFactoryMaker.getBankAccountFactory();
	private Message message = new Message();

	@Override
	public IFrame getFrame() {
		// TODO Auto-generated method stub
		return jframe;
	}

	@Override
	public void setIFrame(IFrame jframe) {
		this.jframe = jframe;
		this.jframe.setController(this);

		tm = new TransactionManager();

		try {
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			this.jframe.setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}

	}

	@Override
	public void transact(TransactionTypes type, String acctNumber, Double value) {
		
		if (acct != null) {
			switch (type) {
			case ADD_INTEREST:
				tm.exeuteTransaction(new AddInterest(value));
				break;
			case WITHDRAW:
				acct = cust.getAccount(acctNumber);
				value = -value;
				tm.exeuteTransaction(new Withdraw(acct, value));
				break;
			case DEPOSIT:
				acct = cust.getAccount(acctNumber);
				tm.exeuteTransaction(new Deposit(acct, value));
				if(acct.getCustomerFlag() =="P"){
					message.info((Component) this.jframe, "An email has been sent to"+acct.getCustomer().getEmail());
				}
				break;
			default:

				break;
			}
		}
	}

	@Override
	public void addCustomer(String[] details) {
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
				message.error((Component) this.jframe, "Wrong Birthday");

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

		acccountManager.addAccount(acct);
	}

	@Override
	public String getAcctNo() {
		return acct.getId();
	}

	@Override
	public Double getBalance() {
		return acct.getBalance();
	}

}
