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
        
        
        //or
        
        /*try {
            s = s.trim();
            int n = s.length();
            if ( n == 0 || (s.charAt(n-1) != '.' && (s.charAt(n-1) - '0' < 0 || s.charAt(n-1) - '0' > 9 )) ) {
                return false;
            }
            double i = Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }*/
        
        
        // regular expression
        
        /*s = s.trim();
	    	if (s.length() == 0)
	    		return false;
	    	if (s.matches("[+-]?(([0-9]*\\.?[0-9]+)|([0-9]+\\.?[0-9]*))([eE][+-]?[0-9]+)?"))
	    		return true;
	    	else
	    		return false;*/
    }
	public static void main(String[] args) {
		System.out.println(isNumber("10e2e"));
	}
}
