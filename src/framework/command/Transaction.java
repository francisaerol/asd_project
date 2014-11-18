package framework.command;

public interface Transaction {

	public void execute();

	public void unexecute();

	public String getTimeStamp();
}
