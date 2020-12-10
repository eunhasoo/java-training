package baekjoon.no1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	List<Integer> getPrimeNumbers(int N) {
		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				for (int j = i * 2; j < isPrime.length; j += i) {
					isPrime[j] = false;
				}
			}
		}
		
		List<Integer> primeNumbers = new ArrayList<>();
		for (int i = 2; i <= N; i++) {
			if (isPrime[i]) {
				primeNumbers.add(i);
			}
		}
		
		return primeNumbers;
	}
	
	void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine());
		
		List<Integer> primeNumbers = getPrimeNumbers(N);
		
		int i, j, sum, count;
		i = j = sum = count = 0;
		while (i < primeNumbers.size()) {
			
			while (j < primeNumbers.size() && sum < N) {
				sum += primeNumbers.get(j++);
			}
			
			if (sum == N) count++;
			
			sum -= primeNumbers.get(i++);
		}
		
		System.out.println(count);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
