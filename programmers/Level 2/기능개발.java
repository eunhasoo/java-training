import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

	public int[] solution(int[] progresses/* 작업 진도 */, int[] speeds/* 작업 속도 */) {
		List<Integer> deploy = new ArrayList<>();  // int 배열에 옮기기 위해 임시로 사용할 list
		Deque<Integer> queue = new ArrayDeque<>(); // 각 작업이 완료되는 작업일을 담을 queue
		for (int i = 0; i < speeds.length; i++) {
			int day = 0;
			while (progresses[i] < 100) { // 작업 완료일 계산
				progresses[i] += speeds[i];
				day++;
			}
			queue.addLast(day);
		}
		int count, head;
		while (true) {
			if (queue.isEmpty()) break;
			count = 1;
			head = queue.removeFirst();
			while (!queue.isEmpty()) {
				if (head - queue.peekFirst() >= 0) { // 앞 작업과 함께 배포 가능하면
					++count;
					queue.removeFirst();
					continue;
				}
				break; // head보다 작업일이 크면 종료
			}
			deploy.add(count);
		}
		int[] answer = new int[deploy.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = deploy.get(i);
		return answer;
	}

}