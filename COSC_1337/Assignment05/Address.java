public class Address {
	   // declare instance fields to be be used in the address
	private String streetAddress, city, state;
	private int zipCode;
	
	public Address(String street, String town, String st, int zip)
	{
		streetAddress = street;
		city = town;
		state = st;
		zipCode = zip;
	}	// end constructor Address
	
	public String toString()
	{
		String result;
		
		result = streetAddress + "\n";
		result += city + ", " + state + " " + zipCode;
		return result;
	}	// end method toString

}   // end class Address
