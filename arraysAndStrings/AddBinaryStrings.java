package arraysAndStrings;

public class AddBinaryStrings {
	public static String addBinary(String a, String b) {
        int sum = 0, carry = 0;
       int l1 = a.length() - 1;
       int l2 = b.length() - 1;
       String result = "";
       
       while(l1 >= 0 || l2 >= 0) {
           int i = (l1 >= 0) ? Character.getNumericValue(a.charAt(l1)) : 0;
           int j = (l2 >= 0) ? Character.getNumericValue(b.charAt(l2)) : 0;
           sum = i + j + carry;
           if(sum == 2) {
           		result = "0" + result;
           		carry = 1;
           } else if(sum == 3) {
	            	result = "1" + result;
	        		carry = 1;
           } else {
           		result = Integer.toString(sum) + result;
           		carry = 0;
           }
           
           if(l1 >= 0)
               l1--;
           if(l2 >= 0)
               l2--;
       }
       if(carry == 1)
       		result = "1" + result;
       return result;
    }
	public static void main(String[] args) {
		System.out.println(addBinary("11", "101"));
	}
}
