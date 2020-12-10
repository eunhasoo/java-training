package baekjoon.no2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int getNthNumber(int N, int K) {
		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		
		int count = 0;
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				if (++count == K) return i; // found
				
				for (int j = i * 2; j < isPrime.length; j += i) {
					if (!isPrime[j]) continue;
					
					isPrime[j] = false;
					if (++count == K) return j; // found
				}
			}
		}

		return -1; // fail
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println(getNthNumber(N, K));
	}

}
