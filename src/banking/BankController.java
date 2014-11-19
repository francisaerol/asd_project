package banking;

import javax.swing.JFrame;

import framework.control.IController;
import framework.control.command.TransactionTypes;
import framework.model.ICustomer;
import framework.view.bank.IFrame;

public class BankController implements IController {

	private IFrame jframe;
	private ICustomer cust;

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

	public void addPersonalCustomer(String[] row) {
		// create the person
		// cust = Fac.createCustomer();
	}

	@Override
	public void transact(TransactionTypes type, Double value) {
		switch (type) {
		case ADD_INTEREST:
			break;
		case WITHDRAW:
			break;
		default:
			break;
		}

	}

}
