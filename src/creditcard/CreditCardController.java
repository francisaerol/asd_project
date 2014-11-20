package creditcard;

import java.awt.Component;

import javax.swing.UIManager;

import creditcard.accounts.CreditCardAccountFactory;
import creditcard.accounts.CreditCardFactoryMaker;
import framework.control.IController;
import framework.control.command.AddInterest;
import framework.control.command.TransactionManager;
import framework.control.command.TransactionTypes;
import framework.manager.AccountManager;
import framework.model.Account;
import framework.model.ICustomer;
import framework.model.ICustomerFactory;
import framework.view.IFrame;
import framework.view.messages.Message;

public class CreditCardController implements IController {

	private IFrame mainFrame;
	private ICustomer customer;
	private TransactionManager tm;

	private ICustomerFactory customerFactory;
	private CreditCardAccountFactory creditCardAccountFactory;
	private AccountManager acccountManager;

	private Account acct;
	private Message message;

	private String reportName = "";
	private String report = "";

	@Override
	public IFrame getFrame() {
		return mainFrame;
	}

	void init() {
		tm = new TransactionManager();
		customerFactory = CreditCardFactoryMaker.getCustomerFactory();
	
		creditCardAccountFactory = CreditCardFactoryMaker
				.getCreditCardFactory();
		message = new Message();
		acccountManager = AccountManager.getInstance();
	}

	@Override
	public void setIFrame(IFrame i) {
		this.mainFrame = i;
		this.mainFrame.setController(this);
		init();

		try {
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			this.mainFrame.setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}

	}

	@Override
	public void transact(TransactionTypes type, String acctNumber, Double value) {
		switch (type) {
		case CHARGE_ACCOUNT:
			acct = acccountManager.getAccount(acctNumber);
			if (value > 400) {
				message.info((Component) mainFrame, "Email for high charging: "
						+ value + " has been sent");
			}
			acct.addNewEntry(-value);
			break;
		case DEPOSIT:
			acccountManager = AccountManager.getInstance();
			acct = acccountManager.getAccount(acctNumber);
			acct.addNewEntry(value);
			break;
		case ADD_INTEREST:
			tm.exeuteTransaction(new AddInterest(value));
			message.info((Component) this.mainFrame, value
					+ "% has been added to all accounts");
		case GENERATE_REPORT:
			break;
		default:
			break;
		}

	}

	@Override
	public void addCustomer(String[] rowdata) {
		
		customer = customerFactory.createPersonalCustomer(rowdata[1],
				rowdata[6]);
	
		customer.addAddress(rowdata[2], rowdata[3], rowdata[4], rowdata[5]);
		String type = rowdata[9];

		creditCardAccountFactory.setAccountCustomer(customer);
		if (type.equalsIgnoreCase("Silver")) {
			acct = creditCardAccountFactory.createSilverAccount(0.0, 0.08);
		} else if (type.equalsIgnoreCase("Gold")) {
			acct = creditCardAccountFactory.createGoldAccout(0.0, 0.1);
		} else if (type.equalsIgnoreCase("Bronze")) {
			acct = creditCardAccountFactory.createBronzeAccount(0.0, 0.06);
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

	@Override
	public String getReportName() {
		return reportName;
	}

	@Override
	public String getReport() {
		return report;
	}

	@Override
	public void addNewAccount(String acnr, String accounType) {
		Account oldAccount = acccountManager.getAccount(acnr);
		ICustomer customer = oldAccount.getCustomer();
		creditCardAccountFactory.setAccountCustomer(customer);
		if (accounType.equalsIgnoreCase("Silver")) {
			acct = creditCardAccountFactory.createSilverAccount(0.0, 0.08);
		} else if (accounType.equalsIgnoreCase("Gold")) {
			acct = creditCardAccountFactory.createGoldAccout(0.0, 0.1);
		} else if (accounType.equalsIgnoreCase("Bronze")) {
			acct = creditCardAccountFactory.createBronzeAccount(0.0, 0.06);
		}
		acccountManager.addAccount(acct);
		
	}
}
