package arraysAndStrings;
public class PatternSearch {
	
	public static void searchPattern(String str, String pattern) {
		int slen = str.length();
		int plen = pattern.length();
		
		if(plen > slen)
			System.out.println("The pattern should be shorter than the string");
		else {
			for(int i = 0; i < slen - plen; i++) {
				int j;
				for(j = 0; j < plen; j++)
					if(str.charAt(j + i) != pattern.charAt(j))
						break;
				
				if(plen == j)
					System.out.println("Pattern found at index " + i);
			}
		}
	}
	
	public static void main(String args[]) {
		String str = "AABAACAADAABAABAA";
		String pattern = "AABA";
		searchPattern(str, pattern);
	}
}
