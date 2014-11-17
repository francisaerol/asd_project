package framework.command;

import java.util.Iterator;
import java.util.List;

import framework.factory.IAccount;
import functor.Functor;

public class GenerateReport implements Transaction {

	private List<IAccount> acctList;
	private Functor functor;

	public GenerateReport(List<IAccount> acctList, Functor functor) {
		this.acctList = acctList;
		this.functor = functor;
	}

	@Override
	public void execute() {
		Iterator<IAccount> acctIter = acctList.iterator();
		while (acctIter.hasNext()) {
			IAccount account = acctIter.next();
			functor.compute(account);
		}

	}

	@Override
	public void unexecute() {
		// TODO Auto-generated method stub

	}

}
