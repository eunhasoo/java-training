package baekjoon.no2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] seq = new int[N];
		
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; st.hasMoreTokens(); i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int i, j, sum, count;
		i = j = sum = count = 0;
		while (i < N) {
			
			while (j < N && sum < M) {
				sum += seq[j++];
			}
			
			if (sum == M) count++;
			
			sum -= seq[i++];
		}
		
		System.out.println(count);
	}

}
