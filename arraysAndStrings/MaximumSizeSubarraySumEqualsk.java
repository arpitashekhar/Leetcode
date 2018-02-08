package arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk {
	public static int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int result = 0, sum = 0;
        hm.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hm.containsKey(sum - k)) result = Math.max(i - hm.get(sum - k), result);
            if (!hm.containsKey(sum)) hm.put(sum, i);
        }
        return result;
    }
	
	public static void main(String[] args) {
        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        System.out.println(maxSubArrayLen(arr, k));
    }
}
