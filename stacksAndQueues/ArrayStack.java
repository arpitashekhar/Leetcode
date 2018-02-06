package stacksAndQueues;

public class ArrayStack implements Stack{
	
	public static final int CAPACITY = 1024; 	// default capacity of the stack
	private int N;	
	private Object S[];
	private int top = -1;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	
	public ArrayStack(int capacity) {
		N = capacity;
		S = new Object[N];
	}

	@Override
	public int size() {
		return top + 1;
	}

	@Override
	public boolean isEmpty() {
		return (top < 0);
	}

	@Override
	public Object top() throws StackEmptyException {
		if(isEmpty())
			throw new StackEmptyException("Stack is empty");
		return S[top];
	}

	@Override
	public void push(Object element) {
		if(size() == N)
			try {
				throw new StackFullException("Stack overflow");
			} catch (StackFullException e) {
				e.printStackTrace();
			}
		S[++top] = element;
	}

	@Override
	public Object pop() throws StackEmptyException {
		if(isEmpty())
			throw new StackEmptyException("Stack is empty");
		Object element = S[top];
		S[top--] = null;
		return element;
	}

}
