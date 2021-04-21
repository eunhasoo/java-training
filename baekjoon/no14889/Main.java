package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	int N;
	int[][] stats;
	boolean[] team; // 스타트 or 링크
	int answer = Integer.MAX_VALUE;
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(reader.readLine());
		stats = new int[N][N];
		team = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < N; j++) {
				stats[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(answer);
	}
	
	void dfs(int idx, int depth) {
		if (depth == N / 2) {
			findMinRemainder();
			return;
		}
		
		for (int i = idx; i < N; i++) {
			if (!team[i]) {
				team[i] = true;
				dfs(i, depth + 1);
				team[i] = false;
			}
		}
	}
	
	void findMinRemainder() {
		int start = 0, link = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (team[i] != team[j]) continue;
				
				int sum = stats[i][j] + stats[j][i]; 
				
				if (team[i]) { 
					start += sum;
				} else { 
					link += sum;
				}
			}
		}
		
		answer = Math.min(answer, Math.abs(start - link));
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
