package arraysAndStrings;
import java.util.*;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	        // Sorting approach
        Arrays.sort(nums);
        int left = 1, right = nums.length - 1;
        for(int i = 0; i< nums.length; i++) {
            if(i==0 || nums[i] > nums[i-1]) {
                right = nums.length - 1;
                left = i + 1;

                if(left >= right)
                    break;
	            
	            while(left < right) {
	                if(nums[i] + nums[left] + nums[right] == 0) {
	                    List<Integer> temp = new ArrayList<Integer>();
	                    temp.add(nums[i]); temp.add(nums[left]); temp.add(nums[right]); 
	                    //if(!result.contains(temp))
	                    		result.add(temp);
	                    left++; right--;
	                    while(left<right && nums[left]==nums[left-1])
	                        left++;
	                    while(left<right && nums[right]==nums[right+1])
	                        right--;
	                } else if(nums[i] + nums[left] + nums[right] < 0) {
	                    left++;
	                } else
	                    right--;
	            }
	        }
        }
        return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {-1, 0, 1, 2, -1, -4};
		threeSum(arr);
	}
}
