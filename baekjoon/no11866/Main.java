package baekjoon.no11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		StringBuilder builder = new StringBuilder();
		
		builder.append('<');
		while (!queue.isEmpty()) {
			for (int i = 0; i < K - 1; i++) {
				queue.add(queue.remove());
			}
			
			builder.append(queue.remove()).append(", ");
		}
		builder.replace(builder.length() - 2, builder.length() - 1, ">");
		
		System.out.print(builder);
	}

}
