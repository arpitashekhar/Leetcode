package arraysAndStrings;
import java.io.File;
import java.util.*;

class ReadFile {
	
	public static TreeMap <String, Integer> map = new TreeMap <String, Integer> ();
	private Scanner x;
	void openFile() {
		try {
			x = new Scanner(new File("resources/File.txt"));
		}
		catch(Exception e) {
			System.out.println("Unable to find file");
		}
	}
	
	void readFile() {
		String word;
		int count;
		while(x.hasNext()) {
			word = x.next();
			if(map.containsKey(word)) {
				count = map.get(word);
				map.put(word, count+1);
			} else {
				map.put(word, 1);
			}
		}
		
		System.out.println(map);
	}
	
	void closeFile() {
		x.close();
	}
}
public class MostFrequentWordInFile {
	public static void main(String args[]) {
		ReadFile r = new ReadFile();
		r.openFile();
		r.readFile();
		r.closeFile();
	}
}
