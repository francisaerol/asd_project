package framework.control;

import framework.control.command.TransactionTypes;
import framework.view.bank.IFrame;

public interface IController {

	public abstract IFrame getFrame();

	public abstract void setIFrame(IFrame i);

	public abstract void transact(TransactionTypes type, Double value);
}
