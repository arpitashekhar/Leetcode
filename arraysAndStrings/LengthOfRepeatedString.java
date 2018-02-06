package arraysAndStrings;

public class LengthOfRepeatedString {
	public int lengthOfString(String first, String second) {
		String duplicate = first;
        int count = 1;
        
        if(first.contains(Character.toString(second.charAt(0)))) {
            while(!duplicate.contains(second) && (duplicate.length() <= 2*second.length())) {
                duplicate+=first;
                count++;
            }
        }
        if(duplicate.contains(second))
            return count;
        return -1;
	}
	public void main(String args[]) {
		// return the number of times string A must be stated such that B 
		// is a substring of the repeated string.
		
        String a = "abcd";
        String b = "cdabcdabcda";
        System.out.println(lengthOfString(a, b));
    }
}
