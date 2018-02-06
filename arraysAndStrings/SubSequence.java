package arraysAndStrings;

public class SubSequence {
	public Boolean isSubSequence(String str1, String str2) {

	// Return true if str1 is a subsequence of str2
    int length1 = str1.length();
    int count = 0;
    
    if(str2.length() < length1)
        return false;
    
    while(str2 != "" && count != length1) {
        if(str2.contains(Character.toString(str1.charAt(0)))){
            int index = str1.indexOf(Character.toString(str1.charAt(0)));
            count++;
            str2 = str2.substring(index + 1);
            str1 = str1.substring(index + 1);
        } else break;
    }
    
    return (count == length1);
    
    
    // Alternative solution
    
    // int j = 0;
    
    // Traverse str2 and str1, and compare current character 
    // of str2 with first unmatched char of str1, if matched 
    // then move ahead in str1
    // m = str1.length(); n = str2.length();
    /* for (int i=0; i<n&&j<m; i++)
        if (str1.charAt(j) == str2.charAt(i))
            j++;*/

    // If all characters of str1 were found in str2
    // return (j==m);
    
	}
    public void main(String args[]) {
    	String str1 = "AXY",str2= "ADXCPY";
    	System.out.println(isSubSequence(str1, str2));
    }
}
