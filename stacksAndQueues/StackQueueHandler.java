package stacksAndQueues;

public class StackQueueHandler extends ArrayStack{
	public static void main() {
		ArrayStack stack1 = new ArrayStack();
		int[] arr = {1,2};
		if(stack1.isEmpty()) {
			stack1.push(arr);
		}
		System.out.println(stack1);
	}
}
