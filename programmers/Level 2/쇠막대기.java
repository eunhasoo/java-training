import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public int solution(String arrangement) {
		int answer = 0;
		char[] arr = arrangement.toCharArray();
		Deque<Character> stack = new ArrayDeque<>();
		boolean isLaser = false;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') { // 여는 괄호인 경우
				isLaser = true;
				stack.push(arr[i]);
				continue;
			}
			if (arr[i] == ')' && isLaser) { // 레이저인 경우
				isLaser = false;
				stack.pop();
				answer += stack.size();
				continue;
			}
			// 닫는 괄호인 경우
			stack.pop();
			answer++;
		}
		
		return answer;
	}
}