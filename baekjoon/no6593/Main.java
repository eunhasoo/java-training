package baekjoon.no6593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int height;
	int row;
	int col;
	int min;
	
	public Point(int height, int row, int col, int min) {
		this.height = height;
		this.row = row;
		this.col = col;
		this.min = min;
	}
}

public class Main {
	static Point start;
	static boolean[][][] visited;
	static char[][][] building;
	static int[][] directions = { 
			{ 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 }, { 0, 0, -1 }, { 0, -1, 0 }, { -1, 0, 0 } 
	};

	static int BFS(int HEIGHT, int ROW, int COL) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			Point current = queue.poll();
			int h = current.height;
			int r = current.row;
			int c = current.col;
			int m = current.min;
			if (building[h][r][c] == 'E') { // 목적지 도착
				return m;
			}
			if (visited[h][r][c]) {
				continue;
			}
			visited[h][r][c] = true;
			for (int d[] : directions) {
				int height = h + d[0];
				int row = r + d[1];
				int col = c + d[2];
				if ((height < 0 || row < 0 || col < 0) || (height >= HEIGHT || row >= ROW || col >= COL)) { // 범위 체크
					continue;
				}
				if (building[height][row][col] == '#') { // 막힌 경로 체크
					continue;
				}
				queue.add(new Point(height, row, col, m + 1));
			}
		}
		return -1; // 경로 탐색 실패
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int L = Integer.valueOf(tokenizer.nextToken()); // 빌딩 층 수
			int R = Integer.valueOf(tokenizer.nextToken()); // 한 층의 행 수
			int C = Integer.valueOf(tokenizer.nextToken()); // 한 층의 열 수
			if ((L == 0 && R == 0 && C == 0))
				break;
			building = new char[L][R][C];
			visited = new boolean[L][R][C];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					building[i][j] = reader.readLine().toCharArray();
					for (int k = 0; k < C; k++) {
						if (building[i][j][k] == 'S') {
							start = new Point(i, j, k, 0);
						}
					}
				}
				reader.readLine();
			}
			int result = BFS(L, R, C);
			if (result == -1) {
				System.out.println("Trapped!");
			} else {
				System.out.printf("Escaped in %d minute(s).\n", result); // 개행문자를 넣지 않으면 틀린다. 정확히 출력하도록 연습!!
			}
		}
	}
}