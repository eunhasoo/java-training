package baekjoon.no7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int height;
		int row;
		int col;
		int dist;

		public Point(int height, int row, int col, int dist) {
			this.height = height;
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}

	static int[][][] store;
	static ArrayList<Point> startPoints = new ArrayList<>();
	static int count = 0;

	static int BFS(int HEIGHT, int ROW, int COL) {
		int[][] direction = { { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 }, { 0, 0, -1 }, { 0, -1, 0 }, { -1, 0, 0 } };
		boolean[][][] visited = new boolean[HEIGHT][ROW][COL];
		Queue<Point> queue = new ArrayDeque<>();
		for (int i = 0; i < startPoints.size(); i++) {
			Point start = startPoints.get(i);
			visited[start.height][start.row][start.col] = true;
			queue.add(start);
		}
		int day = 0;
		while (!queue.isEmpty()) {
			Point current = queue.remove();
			day = Math.max(day, current.dist);
			for (int[] d : direction) {
				int hgtTo = current.height + d[0];
				int rowTo = current.row + d[1];
				int colTo = current.col + d[2];
				if ((hgtTo < 0 || rowTo < 0 || colTo < 0)
					|| (hgtTo >= HEIGHT || rowTo >= ROW || colTo >= COL))
					continue;
				if (store[hgtTo][rowTo][colTo] == -1)
					continue;
				if (visited[hgtTo][rowTo][colTo])
					continue;
				visited[hgtTo][rowTo][colTo] = true;
				queue.add(new Point(hgtTo, rowTo, colTo, current.dist + 1));
				--count;
			}
		}
		if (count == 0)
			return day;
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int M = Integer.valueOf(st.nextToken()); // 열
		int N = Integer.valueOf(st.nextToken()); // 행
		int H = Integer.valueOf(st.nextToken()); // 층
		store = new int[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(reader.readLine());
				for (int k = 0; k < M; k++) {
					store[i][j][k] = Integer.valueOf(st.nextToken());
					if (store[i][j][k] == 1) {
						startPoints.add(new Point(i, j, k, 0));
					}
					if (store[i][j][k] == 0) {
						++count;
					}
				}
			}
		}
		System.out.println(BFS(H, N, M));
	}

}
