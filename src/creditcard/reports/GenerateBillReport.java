package creditcard.reports;

import java.util.List;

import framework.control.functor.Functor;
import framework.model.Account;
import framework.model.Entry;

public class GenerateBillReport implements Functor<Account, String> {

	@Override
	public void compute(Account element) {
		List<Entry> entries = element.getEntries();
		// TODO: We will be implementing the logic for getting all entries;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
