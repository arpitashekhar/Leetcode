package arraysAndStrings;

public class SentenceReverse {
	public static void reverseSentence(String sentence) {
		String[] words = {};
		words = sentence.split(" ");
		String reverse = "";
		
		for(int i = words.length - 1; i >= 0; i--) {
			reverse = reverse + words[i] + " ";
		}
		System.out.println(reverse);
	}
	
	public static void main(String[] args) {
		String sentence = "Today is Makar Sankranti";
		reverseSentence(sentence);
	}
}
