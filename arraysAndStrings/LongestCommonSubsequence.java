package arraysAndStrings;

public class LongestCommonSubsequence {
	public static int longestCommonSubsequence(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        
        for(int i = 0; i <= length1; i++) 
            for(int j = 0; j <= length2; j++) 
            	if(i == 0 || j == 0)
            		dp[i][j] = 0;
        
        
        for(int i = 0; i < length1; i++) {
            for(int j = 0; j < length2; j++) {
            	if(str1.charAt(i) != str2.charAt(j)) {
            		dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            	} else
            		dp[i + 1][j + 1] = dp[i][j] + 1;
            }
        }
        
        System.out.println("Longest common subsequence is: " + printSubsequence(dp, str1));
        return dp[length1][length2];
    } 
	
	public static String printSubsequence(int[][] dp, String str1) {
		String subsequence = "";
		int rows = dp.length - 1;
		int columns = dp[0].length - 1;
        int i = rows, j = columns;
        
        while(dp[i][j] != 0) {
            if(dp[i][j] != Math.max(dp[i-1][j], dp[i][j-1])) {
                subsequence += str1.charAt(i - 1);
                i = i-1;
                j = j-1;
            } else if(dp[i][j] == dp[i-1][j]) {
                i = i-1;
            } else
                j = j-1;
        }	
        StringBuilder reverse = new StringBuilder(subsequence);
        subsequence = reverse.reverse().toString();
		return subsequence;
	}
    
    public void main(String args[]) {
        String str1 = "ABCDEFG", str2 = "ACGEFG";
        
        System.out.println("Length of the longest common subsequence is: " + longestCommonSubsequence(str1, str2));
    }
}
