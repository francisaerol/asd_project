package banking.report;

import framework.control.functor.Functor;
import framework.model.Account;

public class GenerateAccountReport<T, R> implements Functor<T, R> {

	@Override
	public void compute(T element) {
		Account a = (Account) element;

	}

	@Override
	public R getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
