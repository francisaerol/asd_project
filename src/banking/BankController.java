package banking;

import framework.control.IController;
import framework.control.command.AddInterest;
import framework.control.command.Deposit;
import framework.control.command.TransactionManager;
import framework.control.command.TransactionTypes;
<<<<<<< HEAD
import framework.model.Account;
import framework.model.IAccountFactory;
import framework.model.ICompany;
=======
import framework.control.command.Withdraw;
import framework.model.Account;
>>>>>>> FETCH_HEAD
import framework.model.ICustomer;
import framework.model.ICustomerFactory;
import framework.model.IPersonal;
import framework.view.bank.IFrame;
import java.util.Date;
import java.util.List;

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

<<<<<<< HEAD
    @Override
    public ICustomerFactory getCustomerFactory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IAccountFactory getAccountFactory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAccountCustomer(ICustomer cust) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ICompany createCompanyCustomer(String name, String email, Integer noOfEmployess) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPersonal createPersonalCustomer(String name, String email, Date birthdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAddress() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAddress(String street, String city, String state, String zip) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAccount(Account acct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumberOffEmployees() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getBirthdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getStreet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getCity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getZip() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double getValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double getBalance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double getInterest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unexecute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTimeStamp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
=======
>>>>>>> FETCH_HEAD

}
