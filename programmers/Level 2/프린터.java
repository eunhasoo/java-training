import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
	
	class Document {
		int number, priority;
		
		Document(int number, int priority) {
			this.number = number;
			this.priority = priority;
		}
	}
	
	public int solution(int[] priorities, int location) {
		Deque<Document> queue = new ArrayDeque<>();
		for (int i = 0; i < priorities.length; i++) // 큐에 일단 배열순서 그대로 넣는다
			queue.addLast(new Document(i, priorities[i]));
		Arrays.sort(priorities); // 중요도 순으로 정렬(오름차순)해서 이후 비교용으로 사용한다
		int printNo = 1;
		for (int i = priorities.length - 1; i >= 0; i--) {
			while (queue.peekFirst().priority < priorities[i]) { // 해당 인덱스 배열값보다 우선순위가 작으면
				queue.addLast(queue.removeFirst()); // 값을 빼고 다시 넣는 작업 반복
			}
			// 우선순위가 높은값들 먼저 순서대로 큐에서 빼냄
			if (queue.remove().number == location)
				break; // 문서를 찾았으므로 종료
			
			++printNo; // 프린트 순서번호 증가
		}
		return printNo;
	}

}