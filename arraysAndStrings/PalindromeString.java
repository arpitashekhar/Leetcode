package arraysAndStrings;

public class PalindromeString {
	public static boolean isPalindrome(String test) {
		int low = 0, high = test.length() - 1;
		
		while(low <= high) {
			if(test.charAt(low) != test.charAt(high))	return false;
			else {
				low++;
				high--;
			}
		}
		return true;
	}
	public static void reverseNumber(int num) {
		int value = 0;
        while(num > 0) {
            value = num % 10 + (value*10);
            num = num / 10;
        }
        System.out.print(value);
	}
	public static void main(String[] args) {
		String test = "naanadan";
		int num = 122098;
		System.out.println(isPalindrome(test));
		reverseNumber(num);
	}
}
