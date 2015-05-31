public class HEBQueue<T> implements QueueADT<T> {
        // declare instance fields (queue and counter)
    private T[] customer = (T[]) (new Object[3]);
    
       // declare instance fields to keep track of how
       // many elements are being used within a queue, and
       // where the front and rear of the queue(s) are located
    private int customerCounter, rearCustomer, frontCustomer;
        
    public HEBQueue()
    {
        // zero out all counters concerning the queues
        customerCounter = 0;
        rearCustomer = 0;
        frontCustomer = 0;
    }   // end constructor HEBQueue
    
    public boolean fullShoppers()
    {
        if (customerCounter == customer.length) {
            return true; // queue is full
        }
        else
        {
            return false; // queue is NOT full
        }
    }   // end method fullShoppers
    
    public boolean emptyShoppers()
    {
        if (customerCounter == 0) {
            return true; // queue is empty
        }
        else
        {
            return false; // queue is NOT empty
        }
    }   // end method emptyShoppers
    
    public void enqueue(T element)
    {
        // place this shopper at the rear of the queue
        customer(rearCustomer) = element;
        System.out.println("Enqueued " + customer(rearCustomer));

        // adjust rear pointer of the queue for the next future customer
        rearCustomer = (rearCustomer + 1) % customer.length;
        // update the number of elements that are currently in teh queue
        customerCounter++;
    }   // end method enqueue
    
    public T dequeue()
    {
       // decalre variables to hold the dequeued shopper
       T element;
       // dequeue custoemr at the front of the queue
       element = custoemr(frontCustomer); 
        
        System.out.println("Dequeued " + element);
        // adjust front pointer of the queue for the next future custoemr
        frontCustomer = (frontCustomer + 1) % customer.length;
        // update the number of elements that are currently in the queue
        customerCounter--;
        return element;
    }   // end method dequeueCustomer
    
}   // end class HEBQueue
