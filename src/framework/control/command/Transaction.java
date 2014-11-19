package framework.control.command;

public interface Transaction {

	public void execute();

	public void unexecute();

	public String getTimeStamp();
}
