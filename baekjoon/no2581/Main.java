package baekjoon.no2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	
	static ArrayList<Integer> getPrimeNumbers(int M, int N) {
		boolean[] prime = new boolean[N + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for(int i = 2; i <= N; i++)
			if (prime[i]) {
				for(int j = i * 2; j <= N; j += i)
					prime[j] = false;
			}
		ArrayList<Integer> primeList = new ArrayList<>();
		for(int i=M; i<=N; i++)
			if (prime[i])
				primeList.add(i);
		return primeList;
	}
	
	static int getSum(ArrayList<Integer> list) {
		int sum = 0;
		for(int i=0; i<list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.valueOf(reader.readLine());
		int N = Integer.valueOf(reader.readLine());
		ArrayList<Integer> primeList = getPrimeNumbers(M, N);
		if (primeList.isEmpty()) {
			System.out.println(-1);
		} else {
			Collections.sort(primeList);
			System.out.println(getSum(primeList));
			System.out.println(primeList.get(0));
		}
	}

}
