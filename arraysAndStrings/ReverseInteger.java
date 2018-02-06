package arraysAndStrings;

public class ReverseInteger {
	public static int reverse(int x) {
		int result = 0;
        
        while(x != 0) {
            int digit = x % 10;
            result = result * 10 + digit;
            x = x / 10;
        }
        return result;
	}
	
	public static void main(String[] args) {
		System.out.println(reverse(123));
	}
}
