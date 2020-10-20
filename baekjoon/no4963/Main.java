package baekjoon.no4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) break;
			
			int[][] map = new int[h][w];
			boolean[][] visited = new boolean[h][w];
			
			for (int row = 0; row < h; row++) {
				st = new StringTokenizer(reader.readLine());
				for (int col = 0; col < w; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			int count = 0;
			for (int row = 0; row < h; row++) {
				for (int col = 0; col < w; col++) {
					if (map[row][col] == 1 && !visited[row][col]) {
						++count;
						dfs(row, col, map, visited);
					}
				}
			}
			System.out.println(count);
		}
		
	}
	
	int[] dr = { 1, 0, 0, -1, 1, -1, -1, 1 };
	int[] dc = { 0, 1, -1, 0, 1, -1, 1, -1 };

	public void dfs(int row, int col, int[][] map, boolean[][] visited) {
		visited[row][col] = true;
		
		for (int i = 0; i < 8; i++) {
			int rowTo = row + dr[i];
			int colTo = col + dc[i];
			
			if (rowTo < 0 || colTo < 0 || rowTo >= map.length || colTo >= map[0].length) continue;
			if (map[rowTo][colTo] == 0 || visited[rowTo][colTo]) continue;
			
			dfs(rowTo, colTo, map, visited);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
