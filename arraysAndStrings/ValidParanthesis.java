package arraysAndStrings;
import java.util.*;
public class ValidParanthesis {
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
        Boolean flag = false;
        
        if((s.length() == 1) || s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}')
            return false;
        
        for(int i = 0; i < s.length(); i++) {
        	char current = s.charAt(i);
        	char previous = stack.peek();
            if(current == '(' || current == '{' || current == '[') {
            	stack.push(current);
            } else if(stack.empty()) {
            	return false;
            } else if((current == ')' && previous == '(') || (current == ']' && previous == '[') || (current == '}' && previous == '{')) {
            	stack.pop();
            } else
            	return false;
        }
        
        if(stack.empty())
        	flag = true;
        return flag;
    }
	
	public static void main(String args[]) {
		System.out.println(isValid("[)]"));
	}
}
