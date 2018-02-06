package arraysAndStrings;

public class RemoveDuplicates {
	// remove duplicates from a sorted array without extra storage space
	// return the length of array which has no duplicate elements
	
	public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int j = 1;
        for(int i = 1; i < length; i++) {
            if(nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }         
        }
        
        return j;
    }
	
	public void main(String args[]) {
		int[] nums = {1, 2, 2, 2, 3};
		int noDup = removeDuplicates(nums);
		
		for(int i = 0; i < noDup; i++)
			System.out.println(nums[i]);
	}
}
