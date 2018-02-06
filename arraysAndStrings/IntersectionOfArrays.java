package arraysAndStrings;
import java.util.*;

public class IntersectionOfArrays {
	public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i < len1 && j < len2) {
            if(nums1[i] < nums2[j])
                i++;
            else if(nums1[i] > nums2[j])
                j++;
            else {
                result.add(nums1[i]);
                i++; j++;
            }
        }
        
        int[] ans = new int[result.size()];
        for(int x = 0; x < result.size(); x++)
            ans[x] = result.get(x);
        return ans;
    }
}
