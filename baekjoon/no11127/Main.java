package baekjoon.no11127;

import java.util.Scanner;

public class Main {
	
	//====================== Solution v1 ======================//

	int[] dp;
	
	public int tiling_v1(int n) {
		if (dp[n] != 0) return dp[n];
		dp[n] = (tiling(n - 1) + tiling(n - 2) * 2) % 10007;
		return dp[n];
	}
	
	public void run_v1()  {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if (n <= 1) {
			System.out.println(n);
		} else {
			dp = new int[n + 1];
			dp[1] = 1; dp[2] = 3;
			System.out.println(tiling_v1(n));
		}
	}

	//====================== Solution v2 ======================//

	public int tiling_v2(int n) {
		if (n <= 1) return n;
		
		int[] dp = new int[n + 1];
		dp[1] = 1; dp[2] = 3;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
		}
		return dp[n];
	}
	
	public void run_v2()  {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(tiling_v2(n));
	}
	

	public static void main(String[] args)  {
		new Main().run_v1();
		// new Main().run_v2();
	}

}
