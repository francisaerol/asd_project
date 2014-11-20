package framework.control;

import java.awt.Component;

import framework.control.command.TransactionTypes;
import framework.view.IFrame;
import framework.view.messages.Message;

public class Controller implements IController {
	private IFrame jframe;
	private Message msg = new Message();

	@Override
	public IFrame getFrame() {
		return jframe;
	}

	@Override
	public void setIFrame(IFrame jframe) {
		this.jframe = jframe;
		this.jframe.setController(this);
		this.jframe.setVisible(true);
	}

	@Override
	public void transact(TransactionTypes type, String acctNumber, Double value) {
		msg.warning((Component) jframe, "Method has not been implemented");

	}

	@Override
	public void addCustomer(String[] row) {
		msg.warning((Component) jframe, "Method has not been implemented");
	}

	@Override
	public String getAcctNo() {
		msg.warning((Component) jframe, "Method has not been implemented");
		return null;
	}

	@Override
	public Double getBalance() {
		msg.warning((Component) jframe, "Method has not been implemented");
		return null;
	}

	@Override
	public String getReportName() {
		msg.warning((Component) jframe, "Method has not been implemented");
		return null;
	}

	@Override
	public String getReport() {
		msg.warning((Component) jframe, "Method has not been implemented");
		return null;
	}

	@Override
	public void addNewAccount(String acnr, String accounType) {
		msg.warning((Component) jframe, "Method has not been implemented");
	}

}
