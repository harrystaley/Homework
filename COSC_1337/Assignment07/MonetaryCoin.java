
public class MonetaryCoin extends Coin {  // child class
	   // declare an instance field that
	   // represents the value of a coin
	private int value;
	
	public MonetaryCoin(int money)
	{
			// invoke the parent's constructor
		super();
		value = money;
		
	}   // end constructor Monetary
	
	public int getValue()
	{
			// only if and only if it is 
			// heads do we return its value
			// otherwise, do not return
			// its value
		if (getFace() == HEADS)
		{
			return value;
		}

           return 0;   // to be modified
	}   // end method getValue
	
	public String toString()
	{
		String result, coinType;

			// invoke parent's toString method
			// to begin building a string
		result = super.toString();
		
		// concatenate correct wording
		// associated with the coin
		switch(value)
		{
		case 1: coinType = "Penny"; break;
		case 5: coinType = "Nickel"; break;
		case 10: coinType = "Dime"; break;
		case 25: coinType = "Quarter"; break;
		case 50: coinType = "Half Dollar"; break;
		case 100: coinType = "Dollar"; break;
		default: coinType = "Unknown Coin"; 
		
		}
		
		
		   	// complete the string
		result += " " + coinType + " was " + result + 
				 ": " +	((double) value / 100);
		
			return result;  // to be modified
		
	}   // end method toString

}   // end class MonterayCoin
