import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = heights.length - 1; i > 0; i--) {
        	for (int j = i - 1; j >= 0; j--) {
        		if (heights[j] > heights[i]) { // 더 높은 탑 발견
        			stack.push(j + 1);
        			break;
        		}
        		if (j == 0) { // 더 높은 탑을 찾지 못한 경우
        			stack.push(0);
        			break;
        		}
        	}
        }
        stack.push(0); // 맨 첫번째 탑은 무조건 0
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = stack.pop(); // 넣은 순서 반대로 꺼낸다
        }
        return answer;
    }

}