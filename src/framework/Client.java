package framework;

import banking.BankController;
import framework.control.IController;
import framework.view.bank.BankFrm;

public class Client {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException {

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
