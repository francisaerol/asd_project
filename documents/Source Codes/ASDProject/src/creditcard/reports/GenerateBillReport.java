package creditcard.reports;

import java.util.Date;
import java.util.List;

import framework.control.functor.Functor;
import framework.model.Account;
import framework.model.Entry;

public class GenerateBillReport implements Functor<Account, String> {
	private String report = "";
	private Date date = new Date();
	@Override
	public void compute(Account element) {
		List<Entry> entries = element.getEntries();
		report += "Account Name: "+element.getCustomer().getName() +"\n";
		Double previousBalance = 0.0;
		Double newBalance =0.0;
		report += "Entries: \n";
		for(Entry e:entries){
			if(e.getTimeStamp().compareTo(date) == -1 ) {
				previousBalance+= e.getValue();
			}
			if(e.getTimeStamp().compareTo(date) == 0) {
				newBalance+= e.getValue();
			}
		}
		report = previousBalance +" "+ newBalance;
	}

	@Override
	public String getValue() {
		return report;
	}

}
