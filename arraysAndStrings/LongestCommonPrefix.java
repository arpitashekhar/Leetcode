package arraysAndStrings;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
            
        String result = strs[0];
        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                if (result.isEmpty()) return "";
            }
        }
        return result;
    }
	
	// vertical scanning
	
	private String longestCommonPrefix2(String[] strs) {
	    if (strs == null || strs.length == 0) return "";
	    for (int i = 0; i < strs[0].length() ; i++){
	        char c = strs[0].charAt(i);
	        for (int j = 1; j < strs.length; j ++) {
	            if (i == strs[j].length() || strs[j].charAt(i) != c)
	                return strs[0].substring(0, i);             
	        }
	    }
	    return strs[0];
	}
	
	public void main(String args[]) {
		String[] str = {"he-y", "he-ylo", "he-man"};
		System.out.println(longestCommonPrefix(str));
	}
}
