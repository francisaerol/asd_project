package framework.factory.customer;

public class Address implements IAddress {

	private String street;
	private String city;
	private String zip;
	private String state;

	protected Address(String street, String city, String zip, String state) {
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.state = state;
	}

	@Override
	public String getStreet() {
		return street;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public String getZip() {
		return zip;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return "address: " + street + " " + city + " " + state + " " + zip;
	}

}
