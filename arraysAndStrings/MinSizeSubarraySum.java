package arraysAndStrings;

public class MinSizeSubarraySum {
	// Given an array of n positive integers and a positive integer s, find the minimal length of a 
	// contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead
	public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length + 1, sum, count, i = 0;
        
        while(i < nums.length) {
            sum = nums[i]; count = 1;
            if(sum >= s)
                return count;
            for(int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                count++;
                if(sum >= s) {
                    len = Math.min(count, len);
                    i++;
                    break;
                }
                if((sum < s) && (j == nums.length -1))
                    i++;
            }
            if(i == nums.length - 1) 
            		i++;
        }
        if(len == (nums.length + 1))
            return 0;
        else
            return len;
    }
}
