package baekjoon.no1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	int[] dr = { 0, 1, 0, -1 };
	int[] dc = { 1, 0, -1, 0 };
	boolean[] alpha = new boolean[26];
	boolean[][] visited;
	char[][] board;
	int result = 0;

	public void dfs(int row, int col, int depth) {
		if (depth > result) result = depth;
		
		alpha[board[row][col] - 'A'] = true;
		visited[row][col] = true;

		for (int i = 0; i < 4; i++) {
			int rowTo = row + dr[i];
			int colTo = col + dc[i];

			if ((rowTo < 0 || colTo < 0 || rowTo >= board.length || colTo >= board[0].length)
					|| alpha[board[rowTo][colTo] - 'A'] || visited[rowTo][colTo]) continue;

			dfs(rowTo, colTo, depth + 1);
		}
		
		// ★ backtracking
		alpha[board[row][col] - 'A'] = false;
		visited[row][col] = false;
	}

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = reader.readLine().toCharArray();
		}
		dfs(0, 0, 1);
		System.out.println(result);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
