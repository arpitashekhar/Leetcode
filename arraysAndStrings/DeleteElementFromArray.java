package arraysAndStrings;

public class DeleteElementFromArray {
	public static void popElement(int[] arr, int position) {
		if(position > arr.length) {
			System.out.println("Index out of bound");
			return;
		}
		
		position--;
		
		for(int i = position; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		
		for(int j = 0; j < arr.length-1; j++) {
			System.out.println(arr[j]);
		}
	}
	public static void main(String args[]) {
		int[] arr = {1, 4, 2, 5, 9};
		popElement(arr, 4);
	}
}
