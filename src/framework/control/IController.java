package framework.control;

import framework.control.command.TransactionTypes;
import framework.model.Account;
import framework.model.IAccountFactory;
import framework.model.ICompany;
import framework.model.ICustomer;
import framework.model.ICustomerFactory;
import framework.model.IPersonal;
import framework.view.bank.IFrame;
import java.util.Date;
import java.util.List;

public interface IController {

	public IFrame getFrame();

	public void setIFrame(IFrame i);
	public void transact(TransactionTypes type, Double value);
        
        public ICustomerFactory getCustomerFactory();
        public IAccountFactory getAccountFactory();
        public void setAccountCustomer(ICustomer cust);
        
        public ICompany createCompanyCustomer(String name, String email, Integer noOfEmployess);
        public IPersonal createPersonalCustomer(String name,String email,Date birthdate);
        
        public String getName();
        public List getAddress();
        public String getEmail();
        public void addAddress(String street,String city, String state,String zip);
        public void addAccount(Account acct);
        
        public int getNumberOffEmployees();
        public Date getBirthdate();
        
        public void getStreet();
        public void getCity();
        public void getZip();
        public void getState();
        
        public Double getValue();
        public String getId();
        public Double getBalance();
        public Double getInterest();
        
        
        public void execute();
        public void unexecute();
        public String getTimeStamp();
        
        
        
        
}
