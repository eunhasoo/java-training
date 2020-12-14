package baekjoon.no11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	int N;
	int[][] edges;
	boolean[] visited;
	
	void dfs(int idx) {
		for (int i = 0; i < N; i++) {
			if (edges[idx][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
	
	void print() {
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				builder.append(edges[i][j]).append(' ');
			}
			builder.append('\n');
		}
		
		System.out.print(builder);
	}
	
	void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(reader.readLine()); // 1 ≤ N ≤ 100
		
		edges = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < N; j++) {
				edges[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			
			dfs(i);
			
			for (int j = 0; j < N; j++) {
				if (visited[j]) {
					edges[i][j] = 1;
				}
			}
		}
		
		print();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
