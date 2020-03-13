package baekjoon.no2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static class Point {
		int row, col, time;
		
		public Point(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}
	static int ROW;
	static int COL;
	static char[][] map;
	static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int result = 0;

	static void BFS(int rowFrom, int colFrom) {
		boolean[][] visited = new boolean[ROW][COL];
		Queue<Point> queue = new LinkedList<>();
		visited[rowFrom][colFrom] = true;
		queue.add(new Point(rowFrom, colFrom, 0));
		while (!queue.isEmpty()) {
			Point current = queue.remove();
			result = Math.max(result, current.time);
			for (int[] d : directions) {
				int rowTo = current.row + d[0];
				int colTo = current.col + d[1];
				if ((rowTo < 0 || colTo < 0) || (rowTo >= ROW || colTo >= COL)) {
					continue;
				}
				if (map[rowTo][colTo] == 'W') {
					continue;
				}
				if (visited[rowTo][colTo]) {
					continue;
				}
				visited[rowTo][colTo] = true;
				queue.add(new Point(rowTo, colTo, current.time + 1));
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		ROW = Integer.valueOf(st.nextToken());
		COL = Integer.valueOf(st.nextToken());
		map = new char[ROW][COL];
		for (int i = 0; i < ROW; i++) {
			map[i] = reader.readLine().toCharArray();
		}

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (map[i][j] == 'L') {
					BFS(i, j);
				}
			}
		}
		System.out.println(result);
	}

}
