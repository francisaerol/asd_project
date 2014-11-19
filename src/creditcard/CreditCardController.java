package creditcard;

import java.awt.Component;

import javax.swing.UIManager;
import javax.swing.text.html.MinimalHTMLWriter;

import creditcard.accounts.CreditCardAccountFactory;
import creditcard.accounts.CreditCardFactoryMaker;
import framework.control.IController;
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
		switch(type){
		case CHARGE_ACCOUNT:
			acct = acccountManager.getAccount(acctNumber);
			if(value > 400) {
				message.info((Component) mainFrame, "Email for high charging: "+value+" has been sent");	
			}
			acct.addNewEntry(-value);
			break;
		case DEPOSIT:
			acct = acccountManager.getAccount(acctNumber);
			acct.addNewEntry(value);
			break;
		case GENERATE_REPORT:
			break;
		}

	}

	@Override
	public void addCustomer(String[] rowdata) {
		
//		rowdata[0] = "";
//		rowdata[1] = clientName;
//		rowdata[2] = street;
//		rowdata[3] = city;
//		rowdata[4] = state;
//		rowdata[5] = zip;
//		rowdata[6] = email;
//		rowdata[7] = expdate;
//		rowdata[8] = accountType;
//		rowdata[9] = "0";
		customer = customerFactory.createPersonalCustomer(rowdata[1], rowdata[6]);
		System.out.println(customer);
		customer.addAddress(rowdata[2], rowdata[3], rowdata[4], rowdata[5]);
		String type = rowdata[8];
		if(type.equalsIgnoreCase("Silver")){
			acct = creditCardAccountFactory.createSilverAccount(0.0, 0.08); 
		} else if(type.equalsIgnoreCase("Gold")) {
			acct = creditCardAccountFactory.createGoldAccout(0.0, 0.1);
		} else if(type.equalsIgnoreCase("Bronze")) {
			acct = creditCardAccountFactory.createBronzeAccount(0.0, 0.06);
		}
		

	}

	@Override
	public String getAcctNo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getBalance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getReportName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getReport() {
		// TODO Auto-generated method stub
		return null;
	}

}
