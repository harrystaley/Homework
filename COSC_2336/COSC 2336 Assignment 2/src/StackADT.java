
public interface StackADT<T> {
	public abstract boolean full();
	public abstract boolean notEmpty();
	public abstract void push (T element);
	public abstract T pop();
} //end interface StackADT
