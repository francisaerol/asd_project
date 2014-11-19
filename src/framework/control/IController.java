package framework.control;

import framework.control.command.TransactionTypes;
import framework.view.bank.IFrame;

public interface IController {

	public IFrame getFrame();

	public void setIFrame(IFrame i);

	void transact(TransactionTypes type, String acctNumber, Double value);

	void addCustomer(String[] row);

	String getAcctNo();

}
