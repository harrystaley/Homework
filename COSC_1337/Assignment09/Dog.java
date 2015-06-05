
public class Dog implements Speaker {
	private String name;
	
	public Dog(String inName)
	{
		name = inName;
	}
	
	public void speak()
	{
		System.out.println(name + " says: Woof!");
	}
	
	


	public void announce(String str) {
		System.out.println(name + " playfully announces: " + str);
		
	}


		
	}

