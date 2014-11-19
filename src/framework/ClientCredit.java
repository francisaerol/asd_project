package framework;

import creditcard.CreditCardController;
import banking.BankController;
import framework.control.IController;
import framework.view.bank.BankFrm;
import framework.view.creditcard.CardFrm;

public class ClientCredit {
	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException {

		System.out.println(CreditCardController.class.toString());
		// if (args.length == 0) {
		// IController c = (IController) new Controller();
		// } else if (args.length > 0) {

		try {

			Class c = Class.forName("creditcard.CreditCardController");
			IController b = (IController) c.newInstance();
			b.setIFrame(new CardFrm());

		} catch (ClassNotFoundException e) {
			System.out.println("Classssssssssssssssssss");
			e.printStackTrace();
		}

		// }
	}
}
