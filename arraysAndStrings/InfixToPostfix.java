package arraysAndStrings;
import java.util.*;
public class InfixToPostfix {
	public static void convert(String str) {
		Stack<Character> stack = new Stack<Character>();
		String postfix = "";
		
		for(int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			if(Character.isLetter(current)) {
				postfix += current;
			} else {
				if(current == ')') {
					if(stack.peek() == '(')
						stack.pop();
					else
						postfix += stack.pop();
				} else 
					stack.push(current);
			}
		}
		
		while(!stack.empty()) {
			if(stack.peek() == '(')
				stack.pop();
			else
				postfix += stack.pop();
		}
		
		System.out.println(postfix);
	}
	
	public static void main(String args[]) {
		convert("(a+(b*c))/(d+e)");
	}
}
