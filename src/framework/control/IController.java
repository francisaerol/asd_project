package framework.control;

import framework.control.command.TransactionTypes;
import framework.view.IFrame;

public interface IController {

	public IFrame getFrame();

	public void setIFrame(IFrame i);

	public void transact(TransactionTypes type, String acctNumber, Double value);

	public void addCustomer(String[] row);

	public String getAcctNo();

	public Double getBalance();

	public String getReportName();

	public String getReport();

	public void addNewAccount(String acnr, String accounType);

}
