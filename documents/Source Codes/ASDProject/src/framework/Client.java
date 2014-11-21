package framework;

import java.io.IOException;

import framework.control.Controller;
import framework.control.IController;
import framework.view.bank.BankFrm;
import framework.view.ccard.CardFrm;
import framework.view.messages.Message;

public class Client {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, IOException {
		Message msg = new Message();
		String classname = args[0]; // this will be replaced by
														// args[0]
		String system = args[1]; // this will be replaced by args[1];
		try {
			if (classname.length() == 0) {
				IController b = (IController) new Controller();
				b.setIFrame(new BankFrm());
			} else {
				Class c = Class.forName(classname);
				IController b = (IController) c.newInstance();
				if (system.equalsIgnoreCase("B")) {
					b.setIFrame(new BankFrm());
				} else {
					b.setIFrame(new CardFrm());
				}
			}
		} catch (ClassNotFoundException e) {
			msg.error(new BankFrm(), classname + "is not found!");
		}
	}

}
