import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
	
	public int solution(int stock/*현재 남은 밀가수 수량*/, int[] dates/*밀가루 공급 일정*/, 
			int[] supplies/*밀가루 공급 수량*/, int k/*원공장으로부터 공급가능일정*/) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		int suppliedCount, idx;
		suppliedCount = idx = 0;
		
		while (stock < k) {
			while (idx < dates.length && dates[idx] <= stock) {
				queue.add(supplies[idx]);
				++idx;
			}
			stock += queue.poll();
			++suppliedCount;
		}
		
		return suppliedCount;
	}
}