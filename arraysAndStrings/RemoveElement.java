package arraysAndStrings;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int m = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
               nums[m] = nums[i];
               m++;
            }
        }
        
        return m;
    }
    
    public void main(String args[]) {
	    	int[] nums = {1,2,3,3,1,2};
	    	int element = 3;
	    	int index = removeElement(nums, element);
	    	for(int i = 0; i < index; i++){
	    		System.out.print(nums[i] + " ");
	    	}
    }
}
