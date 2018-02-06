package arraysAndStrings;

public class MergeSort {
	public static int[] temp = new int[6];
	public static void mergeSort(int[] arr, int start, int end) {
		
		if(start == end) return;
		int mid = (start + end)/2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		merge(arr, start, mid, end);
	}
	
	public static void merge(int[] arr, int start, int mid, int end) {
		int i = start, j = mid + 1, x = start;
		while(i <= mid && j <= end) {
			if(arr[i] <= arr[j]) {
				temp[x] = arr[i];
				i++;
			} else {
				temp[x] = arr[j];
				j++;
			}
			x++;
		}
		
		while(i <= mid) {
			temp[x] = arr[i];
			x++; i++;
		}
	
		while(j <= end) {
			temp[x] = arr[j];
			x++; j++;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6, 7};
		int start = 0, end = arr.length - 1;
		mergeSort(arr, start, end);
		
		for(int i = 0; i < arr.length; i++)
			System.out.println(temp[i] + "\n");
	}
}
