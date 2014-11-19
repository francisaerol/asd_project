package framework.control;

import framework.control.command.TransactionTypes;
import framework.view.bank.IFrame;

public interface IController {

	public IFrame getFrame();

	public void setIFrame(IFrame i);

	public void addCustomer(String[] details);

	void transact(TransactionTypes type, String acctNumber, Double value);

}
