
public class Philosopher implements Speaker {
	private String name, quote;
	
	public Philosopher(String inName, String inQuote)
	{
		name = inName; 
		quote = inQuote;
	}
	public void speak()
	{
		System.out.println(name + " says: " + quote);
	}

	
	public void announce(String str) 
	{
		System.out.println(name + " announces: " + str);
		
	}
	public void pontificate()
	{
		System.out.println(name + " pontificates: Life is like a box of chocolates.");
	}
}
