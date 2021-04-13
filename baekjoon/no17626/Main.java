package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine());
		
		int[] dp = new int[N + 1]; // n으로 만드는 제곱수의 최소 개수
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			int min = 5;
			
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, dp[i - j * j]);
			}
			
			dp[i] = min + 1;
		}
		
		System.out.println(dp[N]);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
