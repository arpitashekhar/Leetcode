package arraysAndStrings;
import java.util.*;

public class LetterCombinationsOfAPhoneNo {
	public static List<String> letterCombinations(String digits) {
        List<String> rst = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return rst;
        }

        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('0',""); map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        Queue<String> queue = new LinkedList<String>();
        char c = digits.charAt(0);
        String s = map.get(c);
        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i) + "");
        }
        
        int size = 0;
        for (int i = 1; i < digits.length(); i++) {
            c = digits.charAt(i);
            s = map.get(c);
            size = queue.size();
            for (int j = 0; j < size; j++) {
                String str = queue.poll();
                for (int k = 0; k < s.length(); k++) {
                    queue.offer(str + s.charAt(k));
                }
            }
        }
        while (!queue.isEmpty()) {
            rst.add(queue.poll());
        }
        
        return rst;
    }
	public static void main(String[] args) {
		System.out.println(letterCombinations("232"));
	}
}
