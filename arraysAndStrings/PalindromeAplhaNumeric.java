package arraysAndStrings;

public class PalindromeAplhaNumeric {
	public static boolean isPalindrome(String s) {
        String value = s.replaceAll("[-+.^:@#?,\'\";! ()`~$&]","").toLowerCase();
        System.out.println(value);
        boolean flag = true;
        if(value.length() < 2)
            return flag;
        
        int start = 0, end = value.length() - 1; 
        while(start <= end) {
            if(value.charAt(start) != value.charAt(end))
                return false;
            else {
                start++; end--;
            }
        }
        return flag;
    }
	public static void main(String[] args) {
		String test = "naan!@##$#%adan";
		System.out.println(isPalindrome(test));
	}
}
