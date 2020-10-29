package baekjoon.no10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] wines = new int[n + 3];
		for (int i = 3; i < n + 3; i++) {
			wines[i] = Integer.parseInt(reader.readLine());
		}
		
		int[] dp = new int[n + 3];
		int max = 0;
		for (int i = 3; i < n + 3; i++) {
			dp[i] = Math.max(dp[i - 2] + wines[i], 
					dp[i - 3] + wines[i - 1] + wines[i]);
			
			if (dp[i - 1] > dp[i]) { // 포도주를 2번 연속 안 먹을 경우
				dp[i] = dp[i - 1];
			}
			
			if (max < dp[i]) {
				max = dp[i];
			}
		} 
		
		System.out.println(max);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
