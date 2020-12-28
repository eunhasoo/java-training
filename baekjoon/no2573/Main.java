package baekjoon.no2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	class Ice {
		int row, col;

		public Ice(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	int N, M;
	int[][] map;
	int[] dr = {0, 1, 0, -1};
	int[] dc = {1, 0, -1, 0};
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
		while (true) {
			int count = count();
			
			if (count == 0) {
				year = 0;
				break;
			}
			
			if (count >= 2) break;
			
			// 정점을 모두 탐색한 뒤 마지막에만 전체적으로 갱신해주기 위해 임시배열을 생성한다
			int[][] temp = new int[N][M]; 
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 빙산인 경우 1년 뒤 주변 상황으로 인해 변하게 될 상태값을 구한다
					if (map[i][j] > 0) {
						int melted = map[i][j] - getMeltableCount(i, j);
						if (melted < 0) melted = 0;
						
						temp[i][j] = melted;
					}
				}
			}
			
			map = temp;
			
			++year;
		}
		
		System.out.println(year);
 	}
	
	int count() {
		boolean[][] visited = new boolean[N][M];
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0 && !visited[i][j]) {
					++count;
					bfs(i, j, visited);
				}
				
				if (count > 1) return count; // 빙산이 둘로 나뉘면 더 탐색하지 않고 바로 리턴한다
			}
		}
		return count;
	}
	
	void bfs(int row, int col, boolean[][] visited) {
		ArrayDeque<Ice> queue = new ArrayDeque<>();
		queue.add(new Ice(row, col));
		visited[row][col] = true;
		
		while (!queue.isEmpty()) {
			Ice current = queue.remove();
			
			for (int i = 0; i < 4; i++) {
				int rowTo = current.row + dr[i];
				int colTo = current.col + dc[i];
				
				if (rowTo < 0 || colTo < 0 || rowTo >= N || colTo >= M) continue;
				if (visited[rowTo][colTo] || map[rowTo][colTo] == 0) continue;
				
				queue.add(new Ice(rowTo, colTo));
				visited[rowTo][colTo] = true;
			}
		}
	}
	
	int getMeltableCount(int row, int col) {
		int meltableCount = 0;
		
		// 해당 row, col의 동서남북을 탐색해서 0의 개수를 센다
		for (int i = 0; i < 4; i++) { 
			int rowTo = row + dr[i];
			int colTo = col + dc[i];
			
			if (rowTo < 0 || colTo < 0 || rowTo >= N || colTo >= M) continue;
			if (map[rowTo][colTo] == 0) ++meltableCount;
		}
		
		return meltableCount;
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
