package baekjoon.no1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine());
		int[][] board = new int[N][N];
		
		for(int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int col = 0; col < N; col++) {
				board[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][] dp = new long[N][N]; // (경로의 개수 <= 2^63-1) : long 타입 이용
		dp[0][0] = 1; // (0, 0)부터 시작
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (row == N - 1 && col == N - 1) continue;
				
				int rowTo = row + board[row][col];
				int colTo = col + board[row][col];
				
				if (rowTo < N) {
					dp[rowTo][col] += dp[row][col];
				}
				if (colTo < N) {
					dp[row][colTo] += dp[row][col];
				}
			}
		}
		
		for (long[] d: dp)
			System.out.println(Arrays.toString(d).replace("[", "").replace("]",""));
		
		System.out.println(dp[N - 1][N - 1]);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
