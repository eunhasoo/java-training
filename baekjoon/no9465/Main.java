package baekjoon.no9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	int N;
	int[][] stickers;
	int[][] dp;
	
	int getMaxScore(int col, int status) {
		if (N == col) return 0;
		if (dp[col][status] != -1) return dp[col][status];
		
		int score = getMaxScore(col + 1, 0);
		
		if (status != 1) {
			score = Math.max(score, getMaxScore(col + 1, 1) + stickers[0][col]);
		}
		
		if (status != 2) {
			score = Math.max(score, getMaxScore(col + 1, 2) + stickers[1][col]);
		}
		
		dp[col][status] = score;
		
		return score;
	}
	
	void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(reader.readLine());
		
		while (T-- > 0) {
			N = Integer.parseInt(reader.readLine());
			stickers = new int[2][N];
			dp = new int[N][3];
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(dp[i], -1);
			}
				
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(reader.readLine());
				for (int j = 0; j < N; j++) {
					stickers[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println(getMaxScore(0, 0));
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
