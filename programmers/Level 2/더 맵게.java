import java.util.PriorityQueue;

class Solution {

	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for (int n : scoville)
			queue.add(n);
		
		int count = 0, minCalc = 0;
		while (queue.size() > 1 && queue.peek() < K) {
			minCalc = queue.poll() + (queue.poll() * 2);
			queue.add(minCalc);
			++count;
		}
		
		return (queue.peek() >= K) ? count : -1;
	}

}