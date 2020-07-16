import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public int solution(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		
		for (int i = 0; i < s.length(); i++) {
			if (!stack.isEmpty() && stack.peek() == s.charAt(i)) { // 이전 문자와 일치하면 스택에서 제거
				stack.pop();
			}
			else { // 다르면 스택에 넣기
				stack.push(s.charAt(i));
			}
		}

		// 완료되면 스택은 빈 상태여야 함
		return stack.size() == 0 ? 1 : 0;
	}
}