package baekjoon.no11727;

import java.util.Scanner;

public class Main {
	
	int MOD = 10007;
	
	public void run() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] dp = new int[N + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			// dp[i]: 2xi 직사각형을 1x2, 2x2 타일로 채우는 방법의 수
			dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % MOD;
		}
		System.out.println(dp[N]);
	}

	public static void main(String[] args) {
		new Main().run();
	}

}
