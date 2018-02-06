package arraysAndStrings;

public class LargestAndSmallestArray {
	public static void largestAndSmallest(int[] arr) {
		int largest = arr[0], smallest = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > largest)	largest = arr[i];
			if(arr[i] < smallest)	smallest = arr[i];
		}
		System.out.println("Largest value is " + largest + "\nSmallest value is " + smallest);
	}
	public static void main(String[] args) {
		int[] arr = {10, -2147483648, -2};
		largestAndSmallest(arr);
	}
}
