package framework.command;

import java.util.Iterator;
import java.util.List;

import framework.factory.account.Account;
import framework.functor.Functor;

public class GenerateReport implements Transaction {

	private List<Account> acctList;
	private Functor functor;

	public GenerateReport(List<Account> acctList, Functor functor) {
		this.acctList = acctList;
		this.functor = functor;
	}

	@Override
	public void execute() {
		Iterator<Account> acctIter = acctList.iterator();
		while (acctIter.hasNext()) {
			Account account = acctIter.next();
			functor.compute(account);
		}
	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub

	}

}
