package baekjoon.no2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public int goUpStairs(int[] steps) {
		int[][] dp = new int[steps.length][2]; // [x][0]은 +1 계단, [x][1]은 +2 계단 점수 저장
		dp[1][0] = dp[1][1] = steps[1];  // 첫 단계 기본 점수 저장
		for (int i = 2; i < steps.length; i++) {
			dp[i][0] = dp[i - 1][1] + steps[i];			 // 바로 전에 +1만큼 올라온 경우 무조건 +2만큼 이동
			dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + steps[i]; // +1이나 +2중에서 더 큰 점수로 이동
		}
		return Math.max(dp[steps.length - 1][0], dp[steps.length - 1][1]);
	}
	
	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] steps = new int[N + 1];
		for(int i = 1; i <= N; i++)
			steps[i] = Integer.parseInt(reader.readLine());
		System.out.println(goUpStairs(steps));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
