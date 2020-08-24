import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {

	public void operate(String operator, int number) {
		switch (operator) {
		case "I":
			maxQueue.add(number);
			minQueue.add(number);
			break;
		case "D":
			if (!maxQueue.isEmpty()) {
				if (number > 0) {
					minQueue.remove(maxQueue.remove());
				}
				if (number < 0) {
					maxQueue.remove(minQueue.remove());
				}
			}
			break;
		}
	}

	PriorityQueue<Integer> minQueue = new PriorityQueue<>();
	PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

	public int[] solution(String[] operations) {
		StringTokenizer st;
		for (String operation : operations) {
			st = new StringTokenizer(operation);
			operate(st.nextToken(), Integer.parseInt(st.nextToken()));
		}

		if (maxQueue.isEmpty()) {
			return new int[] { 0, 0 };
		}
		return new int[] { maxQueue.remove(), minQueue.remove() };
	}
}