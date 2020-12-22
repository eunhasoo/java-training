package baekjoon.no2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	int N, M;
	char[][] map;
	boolean[][][] visited; // 벽을 부순 상태와 부수지 않은 상태를 분리하기 위해 3차원 배열 이용
	
	int[] dr = { 0, 1, 0, -1 };
	int[] dc = { 1, 0, -1, 0 };

	class Point {
		int row, col;
		int broken; // 벽의 상태를 저장 (부서진 경우 1)
		int path; // 지나온 경로의 수 저장

		public Point(int row, int col, int broken, int path) {
			this.row = row;
			this.col = col;
			this.broken = broken;
			this.path = path;
		}
	}
	
	public int BFS() {
		ArrayDeque<Point> queue = new ArrayDeque<>();

		queue.add(new Point(0, 0, 0, 0));
		visited[0][0][0] = visited[0][0][1] = true;
		
		while (!queue.isEmpty()) {
			Point current = queue.remove();
			
			// (N,M) 지점에 도착 -> 종료
			if (current.row == N - 1 && current.col == M - 1) {
				return current.path + 1;
			}
			
			for (int i = 0; i < 4; i++) {
				int rowTo = current.row + dr[i];
				int colTo = current.col + dc[i];

				if (rowTo < 0 || colTo < 0 || rowTo >= N || colTo >= M) continue;
				
				if (map[rowTo][colTo] == '1') {
					// 다음 칸이 벽이고 부순적도, 방문한 적도 없다면 벽을 부수고 이동
					
					if (current.broken == 0 && !visited[rowTo][colTo][1]) {
						queue.add(new Point(rowTo, colTo, 1, current.path + 1));
						visited[rowTo][colTo][1] = true;
					}
					
				} else {
					// 다음 칸이 벽이 아니고 방문하지 않았다면 그냥 이동
					
					if (!visited[rowTo][colTo][current.broken]) {
						queue.add(new Point(rowTo, colTo, current.broken, current.path + 1));
						visited[rowTo][colTo][current.broken] = true;
					}
				}
			}
		}
		
		return -1; // 경로 찾기 불가능
	}

	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			map[i] = reader.readLine().toCharArray();
		}

		System.out.println(BFS());
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
