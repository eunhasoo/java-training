package baekjoon.no1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	ArrayList<Integer>[] userNumbers;
	int N;
	
	class User {
		int number, step;

		public User(int number, int step) {
			this.number = number;
			this.step = step;
		}
	}
	
	public int bfs(int start) {
		ArrayDeque<User> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		
		queue.add(new User(start, 0));
		visited[start] = true;
		int total = 0;
		while (!queue.isEmpty()) {
			User cur = queue.remove();
			total += cur.step;
			
			for (int next : userNumbers[cur.number]) {
				if (!visited[next]) {
					queue.add(new User(next, cur.step + 1));
					visited[next] = true;
				}
			}
		}
		
		return total;
	}
	
	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		userNumbers = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			userNumbers[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(reader.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			userNumbers[A].add(B);
			userNumbers[B].add(A);
		}
		
		int minPath = 5001, answer = 101;
		for (int number = N - 1; number >= 0; number--) {
			int path = bfs(number);
			if (minPath >= path && answer > number) {
				minPath = path;
				answer = number;
			}
		}
		
		System.out.println(answer + 1);
	}
	

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
