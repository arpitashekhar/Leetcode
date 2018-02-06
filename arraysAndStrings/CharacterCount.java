package arraysAndStrings;

public class CharacterCount {
	public String charCount(String str) {
		String result = "";
		int count = 1;
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == str.charAt(i - 1)) {
				count++;
			} else {
				result = result + count + str.charAt(i - 1);
				count = 1;
			}
		}
		result = result + count + str.charAt(str.length() - 1);
		return result;
	}
	public void main(String args[]) {
		String str = "GGGGrrrrrrrrrrrrrrt";
		System.out.println(charCount(str));
	}
}
