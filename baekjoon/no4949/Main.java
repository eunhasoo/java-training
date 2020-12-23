package algorithm.no4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	boolean checkBrackets(String input) {
		ArrayDeque<Character> stack = new ArrayDeque<>();
		
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			
			// 여는 괄호일 때
			if (cur == '(' || cur == '[') {
				stack.push(input.charAt(i));
				continue;
			}
			
			// 닫는 괄호일 때
			if (cur == ')') {
				if (stack.isEmpty() || stack.pop() != '(') return false;
			} else if (cur == ']') {
				if (stack.isEmpty() || stack.pop() != '[') 	return false;
			}
		}
		
		return stack.isEmpty();
	}
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		while (true) {
			String input = reader.readLine();
			
			if (input.equals(".")) break;
			
			builder.append(checkBrackets(input) ? "yes\n" : "no\n");
		}
		
		System.out.print(builder);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
