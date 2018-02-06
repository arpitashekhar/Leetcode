package arraysAndStrings;


public class TargetSumInArray {
	public static boolean targetSumInArray(int[] arr, int sum) {
		// unsorted array
		/*HashMap <Integer, Integer> value = new HashMap <Integer, Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			if(value.containsKey(arr[i]))
				return true;
			value.put(sum - arr[i], i);
		}*/
		
		// sorted array
		int low = 0; int high = arr.length - 1;
		
		while(low < high) {
			int target = arr[low] + arr[high];
			if(target == sum)	return true;
			else if(target < sum)	low++;
			else high--;
		}
		
		return false;
	}
	public static void main(String args[]) {
		int[] arr = {-2, -1, 4, 4, 9};
		int sum = 10;
		System.out.println(targetSumInArray(arr, sum));
	}
}
