package baekjoon.no1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> minHeap = new PriorityQueue<>();
		Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		while (N-- > 0) {
			int number = Integer.parseInt(reader.readLine());
			
			// 초기값은 최대힙에 넣는다
			if (maxHeap.size() == 0) { 
				maxHeap.add(number);
			} else {
				
				// 최대힙과 최소힙의 개수 차이가 1을 넘지 않도록 한다
				if (maxHeap.size() > minHeap.size()) {
					minHeap.add(number);
				} else {
					maxHeap.add(number);
				}
				
				// 최대힙의 top값이 최소힙의 top값보다 크면 swap한다
				if (maxHeap.peek() > minHeap.peek()) {
					maxHeap.add(minHeap.remove());
					minHeap.add(maxHeap.remove());
				}
			}
			
			// 최대힙의 top(중간값) 출력
			builder.append(maxHeap.peek() + "\n");
		}
		System.out.println(builder);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
