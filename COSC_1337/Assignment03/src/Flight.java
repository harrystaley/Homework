//----------------------------------------------------
// Programmer:	Harry Staley
// Course:		COSC 1337 Section 0005
// Semester:	Fall 2014
// Assignment #: 3
// Due Date:	17 September, 2014
//----------------------------------------------------

public class Flight {
	   	// declare instance fields to be used
		// in our Flight class
	private String airline, origin, destination;
	private int flightNumber;
	
	public Flight(String inAirline, String inOrigin,
				String inDestination,
			     int inFlightNumber)
	{
		airline = inAirline;
		origin = inOrigin;
		destination = inDestination;
		flightNumber = inFlightNumber;
	}   // end constructor Flight
	
	   // implement the four accessor methods
	
	public String getAirline()
	{
		return airline;
	}
	
	public String getOrigin()
	{
		return origin;
	}
	
	public String getDestination()
	{
		return destination;
	}
	
	public int getFlightNumber()
	{
		return flightNumber;
	}
	
	   // implement the four mutator methods
	public void setAirline(String inAirline)
	{
		airline = inAirline;
	}
	
	public void setOrigin(String inOrigin)
	{
		origin = inOrigin;
	}
	
	public void setDestination(String inDestination)
	{
		destination = inDestination;
	}
	
	public void setFlightNumber(int inFlightNumber)
	{
		flightNumber = inFlightNumber;
	}
	
	public String toString()
	{
		String localString;
		
		localString = "(" + airline + ", " + origin + ", " + 
						destination + ", " + 
					flightNumber + ")";
		return localString;
	}

}   // end class Flight

