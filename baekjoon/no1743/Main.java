package baekjoon.no1743;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	boolean[][] trashMap, visited;
	int[] dr = {0, 0, 1, -1};
	int[] dc = {1, -1, 0, 0};

	class Point {
		int row, col;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	int getMaxTrashSize() {
		int size = 0;
		for (int row = 0; row < trashMap.length; row++) {
			for (int col = 0; col < trashMap[0].length; col++) {
				if (trashMap[row][col] && !visited[row][col]) {
					size = Math.max(size, dfs(row, col));
				}
			}
		}
		return size;
	}
	
	int dfs(int row, int col) {
		ArrayDeque<Point> stack = new ArrayDeque<>();
		
		stack.push(new Point(row, col));
		visited[row][col] = true;
		int count = 0;
		while (!stack.isEmpty()) {
			Point point = stack.pop();
			++count;
			
			for (int i = 0; i < 4; i++) {
				int rowTo = point.row + dr[i];
				int colTo = point.col + dc[i];
				
				if (rowTo < 0 || colTo < 0 || colTo >= trashMap[0].length || rowTo >= trashMap.length) continue;
				if (visited[rowTo][colTo] || !trashMap[rowTo][colTo]) continue;
				
				stack.push(new Point(rowTo, colTo));
				visited[rowTo][colTo] = true;
			}
		}
		
		return count;
	}
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 통로 세로 길이 
		int M = Integer.parseInt(st.nextToken()); // 통로 가로 길이 
		int K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기의 개수
		
		trashMap = new boolean[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(reader.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			trashMap[r][c] = true;
		}
		
		System.out.println(getMaxTrashSize());
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
