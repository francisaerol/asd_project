package framework.command;

import java.util.Stack;

public class TransactionManager {
	private Stack<Transaction> transactionList;

	public TransactionManager() {
		transactionList = new Stack<Transaction>();
	}

	public void exeuteTransaction(Transaction transaction) {
		transactionList.add(transaction);
		transaction.execute();
	}

	public void undoTransaction() {
		Transaction transaction = transactionList.pop();
		transaction.unexecute();
	}
}
