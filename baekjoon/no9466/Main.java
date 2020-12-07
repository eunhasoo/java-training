package baekjoon.no9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	int cycleCount;
	int[] students;
	boolean[] visited, finished;

	void dfs(int sNum) {
		visited[sNum] = true;
		
		int nextSnum = students[sNum];
		if (visited[nextSnum]) {
			
			// sNum ~ nextSnum까지의 싸이클을 찾음
			if (!finished[nextSnum]) {
				// 싸이클 내부 정점 갯수 카운트
				int temp = nextSnum;
				while (temp != sNum) {
					temp = students[temp];
					cycleCount++;
				}
				cycleCount++; // 현재 sNum 자신 +1
			}
			
		} else {
			dfs(nextSnum);
		}
		
		// 인접한 다른 정점들을 방문한 뒤 돌아와서 finished 체크
		finished[sNum] = true;
	}
	
	void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(reader.readLine());
		while (T-- > 0) {
			
			int n = Integer.parseInt(reader.readLine());
			students = new int[n + 1];
			visited = new boolean[n + 1];
			finished = new boolean[n + 1];
			cycleCount = 0;
			
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int sNum = 1; sNum <= n; sNum++) {
				// 학생 1이 학생 3을 선택하는 경우 ---> students[1] = 3
				students[sNum] = Integer.parseInt(st.nextToken());
			}
			
			for (int sNum = 1; sNum <= n; sNum++) {
				if (!visited[sNum]) dfs(sNum);
			}
			
			System.out.println(n - cycleCount);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
