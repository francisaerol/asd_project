package framework.control;

import framework.control.command.TransactionTypes;
import framework.view.IFrame;

public interface IController {

	public String getAcctNo();

	public String getReportName();

	public String getReport();

	public Double getBalance();

	public IFrame getFrame();

	public void setIFrame(IFrame i);

	public void transact(TransactionTypes type, String acctNumber, Double value);

	public void addCustomer(String[] row);

	public void addNewAccount(String acnr, String accounType);

}
