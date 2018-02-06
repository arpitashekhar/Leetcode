package stacksAndQueues;

public class ArrayQueue implements Queue {

	public static final int CAPACITY = 10;
	private Object Q[];
	private int N;
	private int front = 0;
	private int rear = 0;
	
	private ArrayQueue() {
		N = CAPACITY;
		Q = new Object[N];
	}
	
	private ArrayQueue(int capacity) {
		N = capacity;
		Q = new Object[N];
	}
	
	public Object front() throws Exception {
		if(rear == front)
			throw new Exception();
		Object temp = Q[front];
		Q[front] = null;
		front++;
		return temp;
	}

	
	public int size() {
		return Q.length;
	}

	public boolean isEmpty() {
		if(front == rear)
			return true;
		return false;
	}

	public void dequeue() {
		Q[front++] = null;
	}

	public void enqueue(Object element) throws Exception {
		if(size() == N)
			throw new Exception();
		Q[rear++] = element;
	}

}
