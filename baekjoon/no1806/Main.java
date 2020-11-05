package baekjoon.no1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] seq = new int[N];
		
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = Integer.MAX_VALUE;
		int end = 0, count = 0, sum = 0;
		for (int start = 0; start < N; start++) {
			
			while (end < N && sum <= S) {
				sum += seq[end++];
				count++;
			}
			
			if (sum >= S) {
				if (result > count) result = count;
			}
			
			sum -= seq[start];
			count--;
		}
		
		System.out.println(result == Integer.MAX_VALUE ? 0 : result);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
