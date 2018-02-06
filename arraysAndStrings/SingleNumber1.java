package arraysAndStrings;
import java.util.*;

// Given an array of integers, every element appears three times except for one, 
// which appears exactly once. Find that single one.
public class SingleNumber1 {
	public int singleNumber(int[] nums) {
        if(nums.length <= 3)
            return nums[0];
        int result = 0;
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry m = (Map.Entry)it.next();
            if((Integer)m.getValue() == 1) {
                result = (Integer)m.getKey();
                break;
            }
        }
        
        return result;
    }
}
