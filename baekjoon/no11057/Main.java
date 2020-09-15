package baekjoon.no11057;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	int MOD = 10007;

	public void countIncreasingNums(int[][] dp, int N) {
		Arrays.fill(dp[0], 1);

		for (int i = 1; i < N; i++) {
			// -9로 끝나는 숫자의 오르막 수는 항상 자기 자신뿐
			dp[i][9] = 1; 
			
			// 길이가 i일 때 j로 시작하는 숫자의 오르막 수는 (이전 행의 값 + 다음 열의 값)개
			for (int j = 8; j >= 0; j--) { 
				dp[i][j] = (dp[i - 1][j] + dp[i][j + 1]) % MOD;
			}
		}
	}

	public void run() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int[][] dp = new int[N][10];
		countIncreasingNums(dp, N);
		
		int answer = 0;
		for (int i = 0; i < 10; i++) {
			answer = (answer + dp[N - 1][i]) % MOD;
		}
		System.out.println(answer);
	}

	public static void main(String[] args) {
		new Main().run();
	}

}
