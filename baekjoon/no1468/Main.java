package baekjoon.no1468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[][] heights = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; st.hasMoreTokens(); j++) {
				heights[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int maxAreaCount = 1; // 잠긴 지역이 없을 경우를 초기값으로 설정
		for (int height = 1; height <= 100; height++) { // 높이는 1이상 100 이하의 정수이다. <-- 문제 포인트
			boolean[][] visited = new boolean[N][N];
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					// 높이가 같거나 낮은 지역을 물에 잠기도록 처리한다
					if (heights[row][col] > 0 && heights[row][col] <= height) {
						heights[row][col] = -1;
					}
				}
			}
			
			int areaCount = 0;
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (heights[row][col] > 0 && !visited[row][col]) {
						++areaCount;
						dfs(row, col, heights, visited);
					}
				}
			}
			
			if (areaCount > maxAreaCount) maxAreaCount = areaCount;
		}
		
		System.out.println(maxAreaCount);
	}
	
	int[] dr = {1, 0, 0, -1};
	int[] dc = {0, 1, -1, 0};
	
	public void dfs(int row, int col, int[][] heights, boolean[][] visited) {
		visited[row][col] = true;
		
		for (int i = 0; i < 4; i++) {
			int rowTo = row + dr[i];
			int colTo = col + dc[i];
			
			if (rowTo < 0 || colTo < 0 || rowTo >= heights.length || colTo >= heights[0].length) continue;
			if (heights[rowTo][colTo] < 0 || visited[rowTo][colTo]) continue;
			
			dfs(rowTo, colTo, heights, visited);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
