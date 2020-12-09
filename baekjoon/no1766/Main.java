package baekjoon.no1766;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] problems = new ArrayList[N + 1];
		int[] indegree = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			problems[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			problems[a].add(b);
			indegree[b]++;
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		StringBuilder builder = new StringBuilder();
		
		for (int num = 1; num <= N; num++) {
			if (indegree[num] == 0) queue.add(num);
		}
		
		while (!queue.isEmpty()) {
			int num = queue.remove();
			
			builder.append(num).append(' ');
			
			for (int i = 0; i < problems[num].size(); i++) {
				int nextNum = problems[num].get(i);
				indegree[nextNum]--;
				
				if (indegree[nextNum] == 0) queue.add(nextNum);
			}
		}
		
		System.out.println(builder);
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
