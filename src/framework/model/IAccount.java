package framework.model;

import framework.manager.AccountManager;

public interface IAccount {
	public Double getBalance();

	public Double getInterest();

	public String getId();

	public void update();

	public void setManager(AccountManager mnr);
}
