package arraysAndStrings;

public class ValidNumber {
	// Check if entered string is a valid number
	
	public static boolean isNumber(String s) {
        s = s.trim();
        try {
            Integer.parseInt(s);
            
        } catch(NumberFormatException e) {
            try {
                Float.parseFloat(s);
            } catch(NumberFormatException ex) {
                return false;
            }
        }
        if(s.contains("f") || s.contains("D"))
            return false;
        return true;
    }
	public static void main(String[] args) {
		System.out.println(isNumber("10e2e"));
	}
}
