package framework.view;

import framework.control.IController;

public interface IFrame {

	public abstract void setController(IController control);

	public abstract void setVisible(boolean b);

}
