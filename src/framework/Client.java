package framework;

import banking.BankController;
import framework.control.IController;
import framework.view.bank.BankFrm;

public class Client {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException {

		System.out.println(BankController.class.toString());
		// if (args.length == 0) {
		// IController c = (IController) new Controller();
		// } else if (args.length > 0) {

		try {
			Class c = Class.forName("banking.BankController");
			IController b = (IController) c.newInstance();
			b.setIFrame(new BankFrm());

		} catch (ClassNotFoundException e) {
			System.out.println("Classssssssssssssssssss");
			e.printStackTrace();
		}

		// }
	}

}
