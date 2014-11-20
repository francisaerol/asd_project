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
		try {
			if (args.length == 0) {
				IController b = (IController) new Controller();
				b.setIFrame(new BankFrm());
			} else {
				Class c = Class.forName(args[0]);
				IController b = (IController) c.newInstance();
				if (args[1].equalsIgnoreCase("B")) {
					b.setIFrame(new BankFrm());
				} else {
					b.setIFrame(new CardFrm());
				}
			}
		} catch (ClassNotFoundException e) {
			msg.error(new BankFrm(), args[0] + "is not found!");
		}
	}

}
