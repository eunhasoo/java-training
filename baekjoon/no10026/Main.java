package baekjoon.no10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	char[][] grid;
	boolean[][] visited;
	int[] dx = { 1, 0, 0, -1 };
	int[] dy = { 0, 1, -1, 0 };
	
	public void dfs(int row, int col) {
		visited[row][col] = true;
		
		for(int i = 0; i < 4; i++) {
			int rowTo = row + dy[i];
			int colTo = col + dx[i];
			
			if (rowTo > grid.length - 1 || colTo > grid[0].length - 1
				|| rowTo < 0 || colTo < 0) continue;
			if (visited[rowTo][colTo]) continue;
			
			if (grid[row][col] == grid[rowTo][colTo]) {
				dfs(rowTo, colTo);
			}
		}
	}

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		grid = new char[N][N];
		for (int i = 0; i < N; i++) {
			grid[i] = reader.readLine().toCharArray();
		}
		
		int notColorblinded = 0; // 적녹색약이 아닌 사람이 보는 구역 수
		visited = new boolean[N][N];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (!visited[i][j]) {
					++notColorblinded;
					dfs(i, j);
				}
			}
		}
		
		// 적녹색약인 사람이 보는 것처럼 그리드를 바꾼다
		for (int i = 0; i < grid.length; i++) { 
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 'G') 
					grid[i][j] = 'R';
			}
		}
		
		int colorblinded = 0; // 적녹색약인 사람이 보는 구역 수
		visited = new boolean[N][N];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (!visited[i][j]) {
					colorblinded++;
					dfs(i, j);
				}
			}
		}
		
		System.out.println(notColorblinded + " " + colorblinded);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
