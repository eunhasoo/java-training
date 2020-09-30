package baekjoon.no1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	int[][] field;
	boolean[][] visited;
	int[][] direction = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
	
	public void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int[] d : direction) {
			int xTo = x + d[0];
			int yTo = y + d[1];
			
			if (xTo < 0 || yTo < 0 || xTo > field.length - 1 || yTo > field[0].length - 1) continue;
			if (visited[xTo][yTo] || field[xTo][yTo] == 0) continue;
			
			dfs(xTo, yTo);
		}
	}

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		StringTokenizer st;
		while (T-- > 0) {
			st = new StringTokenizer(reader.readLine());
			int M = Integer.parseInt(st.nextToken()); // 배추밭 가로길이
			int N = Integer.parseInt(st.nextToken()); // 배추밭 세로길이
			int K = Integer.parseInt(st.nextToken()); // 배추가 심어진 위치 수
			field = new int[M][N];
			visited = new boolean[M][N];
			int r, c;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(reader.readLine());
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				field[r][c] = 1;
			}
			int count = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && field[i][j] == 1) {
						++count;
						dfs(i, j);
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
