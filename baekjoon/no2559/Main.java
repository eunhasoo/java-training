package baekjoon.no2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] prefixSum = new int[N + 1];
		
		st = new StringTokenizer(reader.readLine());
		for (int i = 1; i <= N; i++) {
			prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = N; i >= K; i--) {
			int sum = prefixSum[i] - prefixSum[i - K];
			max = Math.max(sum, max);
		}
		System.out.println(max);
	}

}
