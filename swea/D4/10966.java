import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static class Node {
		int row, col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			ArrayDeque<Node> queue = new ArrayDeque<>();
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[N][M];
			int[][] dp = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				String s = reader.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == 'W') {
						queue.add(new Node(i, j));
						dp[i][j] = -1;
					}
				}
			}
			
			while (!queue.isEmpty()) {
				Node cur = queue.remove();
				
				for (int i = 0; i < 4; i++) {
					int rowTo = cur.row + dr[i];
					int colTo = cur.col + dc[i];
					
					if (rowTo < 0 || colTo < 0 || rowTo >= N || colTo >= M) continue;
					if (dp[rowTo][colTo] != 0 || map[rowTo][colTo] == 'W') continue;
					
					if (dp[cur.row][cur.col] != -1) {
						dp[rowTo][colTo] += dp[cur.row][cur.col];
					}
					dp[rowTo][colTo] += 1;
					queue.add(new Node(rowTo, colTo));
				}
			}
			
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (dp[i][j] > 0) result += dp[i][j];
				}
			}
			
			System.out.printf("#%d %d\n", test_case, result);
		}
	}
}
