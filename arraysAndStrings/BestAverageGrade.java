package arraysAndStrings;
import java.util.*;
public class BestAverageGrade {
	public int averageGrade(String[][] arr) {
		int average = 0;
		int count = 0;
		int maxAverage = 0;
		Map<String, Integer> marks = new HashMap<String, Integer>();
		Map<String, Integer> frequency = new HashMap<String, Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			String name = arr[i][0];
			int score = Integer.parseInt(arr[i][1]);
			if(!marks.containsKey(name)) {
				marks.put(name, score);
			} else {
				int cumScore = marks.get(arr[i][0]) + score;
				marks.put(name, cumScore);
				frequency.put(name, count);
				count++;
			}
		}
		
		for (Map.Entry<String, Integer> name : marks.entrySet()){
            String key = name.getKey();
            int totalMarks = name.getValue(); 
            int freq = frequency.get(key);
            average = totalMarks/freq;
            System.out.println(key + " " + average);  
            maxAverage = Math.max(maxAverage, average);
		} 
		return maxAverage;
	}
	public void main(String args[]) {
		String[][] str = { {"Arpita", "100"}, {"Raj", "22"}, {"Rahul", "95"}, {"Raj", "59"} };
		System.out.println(averageGrade(str));
	}
}
