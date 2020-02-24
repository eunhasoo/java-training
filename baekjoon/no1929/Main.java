package baekjoon.no1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean[] getPrimeNumbers(int N) {
		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for(int i = 2; (i * i) <= N; i++) {
			if (isPrime[i])
				for(int j = i * 2; j <= N; j += i) {
					isPrime[j] = false;
				}
		}
		return isPrime;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int M = Integer.valueOf(st.nextToken());
		int N = Integer.valueOf(st.nextToken());
		boolean[] primeList = getPrimeNumbers(N);
		for(int i = M; i < primeList.length; i++)
			if (primeList[i])
				builder.append(i+"\n");
		System.out.println(builder);
	}

}
