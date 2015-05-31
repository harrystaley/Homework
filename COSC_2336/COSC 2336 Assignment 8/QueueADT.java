public interface QueueADT<T> {
    // define our abstract methods
    public boolean fullShoppers();
    public abstract boolean emptyshoppers();
    public abstract void enqueue(T element);
    public abstract T dequeue();
} // end interface QueueADT