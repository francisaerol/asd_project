package framework.model;

import java.util.Date;

public class Entry implements IEntry {
	private Double value;
	private Date timeStamp;

	public Entry(Double value, Date timeStamp) {
		this.value = value;
		this.timeStamp = timeStamp;
	}

	@Override
	public Date getTimeStamp() {
		return timeStamp;
	}

	@Override
	public Double getValue() {
		return value;
	}

}
