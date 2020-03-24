package baekjoon.no4989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public int getPrimeCount(int n) {
		boolean[] prime = new boolean[(n * 2) + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for(int i = 2; (i * i) <= (n * 2); i++)
			if (prime[i])
				for(int j = i * 2; j <= (n * 2); j += i) {
					prime[j] = false;
				}
		int count = 0;
		for(int i = n + 1; i < prime.length; i++) {
			if (prime[i]) count++;
		}
		return count;
	}
	
	public void start() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input = reader.readLine();
			if (input.equals("0")) break;
			int n = Integer.valueOf(input);
			System.out.println(getPrimeCount(n));
		}
	}
	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.start();
	}

}
