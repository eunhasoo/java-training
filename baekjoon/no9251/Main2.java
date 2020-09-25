package baekjoon.no9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public void LCS(char[] x, char[] y) {
		int[][] dp = new int[x.length + 1][y.length + 1];

		for (int i = 1; i <= x.length; i++) {
			for (int j = 1; j <= y.length; j++) {
				if (x[i - 1] == y[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		
		System.out.println(dp[x.length][y.length]);
	}
	
	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String x = reader.readLine();
		String y = reader.readLine();
		LCS(x.toCharArray(), y.toCharArray());
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
