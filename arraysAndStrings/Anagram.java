package arraysAndStrings;

public class Anagram {
	public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;
        
        int len = s.length();
        int[] arr = new int[26];
        for(int i = 0; i < len ; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < len; i++) {
            if(--arr[t.charAt(i) - 'a'] < 0)
                return false;
        }
        
        return true;
        
    }
}
