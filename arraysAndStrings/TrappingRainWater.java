package arraysAndStrings;

public class TrappingRainWater {
	// Given n non-negative integers representing an elevation 
	// map where the width of each bar is 1, compute how much water it is able to trap after raining.
	
	public static int trap(int[] height) {
        int water = 0, left = 0, right = height.length - 1, leftMax = 0, rightMax = 0;
        if(height.length == 1)
            return 0;
        
        while(left < right) {
            if(height[left] < height[right]) {
                if(height[left] > leftMax) 
                    leftMax = height[left];
                else 
                    water += leftMax - height[left];
                left++;
            } else {
                if(height[right] > rightMax)
                    rightMax = height[right];
                else
                    water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
	
	public static void main(String[] args) {
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(arr));
	}
}
