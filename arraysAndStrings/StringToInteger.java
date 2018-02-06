package arraysAndStrings;

public class StringToInteger {
	public static int myAtoi(String str) {
        if(str == null || str.length() < 1)
            return 0;
        str = str.trim();
        double result = 0;
        char sign = '+';
        int index = 0;
        if(str.charAt(index) == '-') {
            sign = '-';
            index++;
        } else if(str.charAt(index) == '+') {
            sign = '+';
            index++;
        }
        
        
        while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            result = result*10 + str.charAt(index) - '0';
            index++;
        }
        
        if(sign == '-')
            result = -result;
        if(result > Integer.MAX_VALUE)
            result = Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE)
            result = Integer.MIN_VALUE;
        
        return (int) result;
    }
	
	public static void main(String[] args) {
		System.out.println(myAtoi("45678"));
	}
}
