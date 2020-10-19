package baekjoon.no11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> {
			int r = Math.abs(n1) - Math.abs(n2);
			return (r == 0) ? (n1 - n2) : r;
		});
		StringBuilder builder = new StringBuilder();
		
		int N = Integer.parseInt(reader.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(reader.readLine());
			
			if (x == 0) {
				if (queue.isEmpty()) builder.append(0 + "\n");
				else builder.append(queue.poll() + "\n");
				continue;
			}
			
			queue.add(x);
		}
		
		System.out.println(builder);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
