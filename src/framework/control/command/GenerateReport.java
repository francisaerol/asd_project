package framework.control.command;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import framework.control.functor.Functor;
import framework.manager.AccountManager;
import framework.model.Account;

public class GenerateReport implements Transaction {

	private List<Account> acctList;
	private Functor functor;
	private Date timeStamp;

	public GenerateReport(Functor functor) {
		this.acctList = AccountManager.getInstance().getAccountList();
		this.functor = functor;
	}

	@Override
	public void execute() {
		Iterator<Account> acctIter = acctList.iterator();
		while (acctIter.hasNext()) {
			Account account = acctIter.next();
			functor.compute(account);
		}
		timeStamp = new Date();
	}

	@Override
	public void unexecute() {

	}

	@Override
	public String getTimeStamp() {
		return timeStamp.toString();
	}

}
