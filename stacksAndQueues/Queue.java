package stacksAndQueues;

public interface Queue {

	// accessor methods
	public Object front() throws Exception;
	public int size();
	public boolean isEmpty();
	
	// update methods
	public void dequeue();	// remove from front
	public void enqueue(Object element) throws Exception;	// add at rear
}
