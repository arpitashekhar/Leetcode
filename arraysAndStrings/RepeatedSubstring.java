package arraysAndStrings;
public class RepeatedSubstring {
	public static boolean repeatedSubstringPattern(String s) {
        int index = 1, count = 0;
        char c = s.charAt(0);
        while(c != s.charAt(index)) {
        		index++;
        }
        System.out.println(index);
        String first = s.substring(0, index);
        System.out.println(first);
        double occurences = Math.floor(s.length()/first.length());
        System.out.println(occurences);
        String substr = s.substring(index);
        while(substr != "" && index != -1) {
	        	substr = s.substring(index);
	        	index = s.indexOf(first);
	        	count++;
        }
        /*if(occurences == 0)
            return false;
        
        for(int j = 0; j < occurences; j++) {
            String substr = s.substring(index);
            index = substr.indexOf(first);
            if(index == -1)
                return false;
            else count++;
        }
        
        if(count == occurences) return true;
        else return false;*/
		return false;
    }
	
	public static void main(String args[]) {
		System.out.println(repeatedSubstringPattern("abab"));
	}
}
