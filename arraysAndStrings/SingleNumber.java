package arraysAndStrings;

public class SingleNumber {
	
	// Given an array of integers, every element appears twice except for one. Find that single one.
	public int singleNumber(int[] nums) {
        int result = nums[0];
	    
	    for(int i = 1; i < nums.length; i++) {
	        result = result ^ nums[i];
	    }
	    
	    return result;
    }
	
	// 2∗(a+b+c)−(a+a+b+b+c) = c   - Without extra Space
    		
}
