
public class ArrayStack<T> implements StackADT<T>{
	   // declare instance fields (stack and counter)
	private T[] stack = (T[]) (new Object[70]);
	private int stackCounter;
	
	public ArrayStack()
	{
		stackCounter =0;
	}   // end constructor ArrayStack
	
	public boolean full()
	{	
		//is the stack full?
		if (stackCounter == stack.length)
		{
			return true; //stack is full
		} //end stack counter full test
		else
		{
			return false; //stack is not full
		}
	}   // end method full
	
	public boolean notEmpty()
	{	
		//is the stack empty
		if (stackCounter != 0)
		{
			return true; //stack is not empty
		}
		else
		{
			return false; //stack is empty
		}
	}   // end method notEmpty
	
	public void push (T element)
	{	
		//push the character onto the stack and then increment the stack counter by one.
		stack[stackCounter] = element;
		stackCounter++;
		System.out.println("Pushed: " + element);
	}   // end method push
	
	public T pop()
	{	
		//decrement the stack counter then pop off the stack the current item and then return the item
		T oneItem;
		--stackCounter;
		oneItem = stack[stackCounter];
		System.out.println("Popped: " + oneItem);
		return stack[0];
		
	}   // end method pop
	
}   // end class ArrayStack

