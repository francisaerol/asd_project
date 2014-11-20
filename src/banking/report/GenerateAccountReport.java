package banking.report;

import framework.control.functor.Functor;
import framework.model.Account;

public class GenerateAccountReport implements Functor<Account, String> {
	private String report = "ID \t Balance \t Interest \t Customer \n";

	@Override
	public void compute(Account element) {
		report += element.getId() + "\t" + element.getBalance() + "\t"
				+ element.getInterest() + "% \t"
				+ element.getCustomer().getName() + "\n";
	}

	@Override
	public String getValue() {
		return report;
	}

}
