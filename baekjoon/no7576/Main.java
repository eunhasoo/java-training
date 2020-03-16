package baekjoon.no7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int row;
		int col;
		int dist;

		public Point(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}
	static int r, c;
	static int[][] store;
	static boolean[][] visited;
	static ArrayList<Point> startPoints;
	static int count = 0;
	static int[][] direction = { {0,1}, {1,0}, {0,-1}, {-1,0} };
	
	public static int BFS() {
		Queue<Point> queue = new ArrayDeque<>();
		for (int i = 0; i < startPoints.size(); i++) {
			Point start = startPoints.get(i);
			queue.add(start);
			visited[start.row][start.col] = true;
		}
		int day = 0; // 토마토가 익는 데 걸리는 날 수
		while (!queue.isEmpty()) {
			Point p = queue.remove();
			System.out.printf("%d %d\n", day, p.dist);
			day = Math.max(day, p.dist);
			for(int[] d : direction) {
				int rowTo = p.row + d[0];
				int colTo = p.col + d[1];
				if ((rowTo < 0 || colTo < 0) || (rowTo >= r || colTo >= c)) continue;
				if (visited[rowTo][colTo] || store[rowTo][colTo] == -1) continue;
				visited[rowTo][colTo] = true;
				queue.add(new Point(rowTo, colTo, p.dist + 1));
				--count;
			}
		}
		if (count == 0)
			return day;
		return -1; // 모두 익지 못하는 상황
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		c = Integer.valueOf(st.nextToken());
		r = Integer.valueOf(st.nextToken());
		store = new int[r][c];
		visited = new boolean[r][c];
		startPoints = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < c; j++) {
				store[i][j] = Integer.parseInt(st.nextToken());
				if (store[i][j] == 1)
					startPoints.add(new Point(i, j, 0));
				if (store[i][j] == 0)
					++count; // 모두 익지 못하는 상황을 체크하기 위한 카운트 + 1
			}
		}
		System.out.println(BFS());
	}

}
