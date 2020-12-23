package algorithm.no2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	int calculate(String input) {
		ArrayDeque<Character> stack = new ArrayDeque<>();
		
		int result = 0;
		int temp = 1; // 분배법칙 이용
		
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			
			// 여는 괄호
			if (cur == '(') {
				stack.push(cur);
				temp *= 2;
			} else if (cur == '[') {
				stack.push(cur);
				temp *= 3;
			}
			
			// 닫는 괄호
			if (cur == ')') {
				if (stack.isEmpty() || stack.pop() != '(') // fail
					return 0;
				
				if (input.charAt(i - 1) == '(') {
					result += temp;
				}
				temp /= 2;
				
			} else if (cur == ']') {
				if (stack.isEmpty() || stack.pop() != '[') // fail
					return 0;
				
				if (input.charAt(i - 1) == '[') {
					result += temp;
				}
				temp /= 3;
			}
		}
		
		return stack.isEmpty() ? result : 0; // 마지막으로 스택이 비었는지 검사
	}
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String input = reader.readLine();
		
		System.out.println(calculate(input));
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
