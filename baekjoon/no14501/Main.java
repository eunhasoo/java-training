package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine());
		
		int[] time = new int[N + 1]; 	// 상담 완료 소요 시간
		int[] profit = new int[N + 1];  // 지급 금액
		
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(reader.readLine());
			time[i] = Integer.parseInt(st.nextToken()); 
			profit[i] = Integer.parseInt(st.nextToken()); 
		}
		
		// 마지막 날부터 시작하는 것이 이해하기 더 쉽다
		int[] dp = new int[N + 2];
		for (int day = N; day > 0; day--) {
			int nextDay = time[day] + day;
			
			if (nextDay > N + 1) {
				dp[day] = dp[day + 1];
			} else {
				dp[day] = Math.max(dp[day + 1], dp[nextDay] + profit[day]);
			}
		}
		
		System.out.println(dp[1]);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
