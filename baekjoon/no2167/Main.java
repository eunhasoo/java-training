package baekjoon.no2167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 단순 배열 이용
	public void run_v1() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder builder = new StringBuilder();
		int k = Integer.parseInt(reader.readLine());
		while (k-- > 0) {
			st = new StringTokenizer(reader.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;

			int sum = 0;
			for (int i = x1; i <= x2; i++) {
				for (int j = y1; j <= y2; j++) {
					sum += arr[i][j];
				}
			}
			builder.append(sum + "\n");
		}

		System.out.println(builder);
	}

	// DP 적용
	public void run_v2() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][m + 1];
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = dp[i - 1][j] - dp[i - 1][j - 1] + dp[i][j - 1] + arr[i][j];
			}
		}

		StringBuilder builder = new StringBuilder();
		int k = Integer.parseInt(reader.readLine());
		while (k-- > 0) {
			st = new StringTokenizer(reader.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int res = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
			builder.append(res + "\n");
		}
		
		System.out.println(builder);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run_v1();
		new Main().run_v2();
	}

}
