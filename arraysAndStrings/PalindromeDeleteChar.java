package arraysAndStrings;

public class PalindromeDeleteChar {
	public boolean isPalindrome(String str) {
        int first = 0, last = str.length() - 1;
        while(first <= last) {
            if(str.charAt(first) != str.charAt(last))
                return false;
            first++; 
            last--;
        }
        return true;
    }
    
    public boolean validPalindrome(String str) {
        if(isPalindrome(str))
            return true;
        int first = 0, last = str.length() - 1, count = 0;
        boolean flag = false;
        while(first <= last) {
            if(str.charAt(first) == str.charAt(last)) {
                first++;
                last--;
            } else {
                return (isPalindrome(str.substring(first+1, last+1)) || isPalindrome(str.substring(first, last)));
            }
        }
        return flag;
    }
}
