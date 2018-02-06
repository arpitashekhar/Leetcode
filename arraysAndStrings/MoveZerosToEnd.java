package arraysAndStrings;

public class MoveZerosToEnd {
	public void moveZeroes(int[] nums) {
        int j = 1, x = 0;
        while(j < nums.length) {
            if(nums[x] == 0 && nums[j] != 0) {
                nums[x] = nums[j];
                nums[j] = 0;
                j++;
                x++;
            } else if(nums[x] != 0) {
                j++;
                x++;
            }
            else {
                if(j == (nums.length - 1))
                    break;
                
                while(j < nums.length && nums[j] == 0)
                    j++;
                
            }
        }
    }
}
