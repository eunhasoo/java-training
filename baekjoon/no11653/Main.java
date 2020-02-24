package baekjoon.no11653;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static ArrayList<Integer> getPrimeNumbers(int n) {
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; (i * i) <= n; i++)
			if (isPrime[i]) {
				for (int j = i * 2; j <= n; j += i)
					isPrime[j] = false;
			}
		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i = 2; i <= n; i++)
			if (isPrime[i])
				primeList.add(i);
		return primeList;
	}

	public static ArrayList<Integer> getPrimeFactors(int n) {
		ArrayList<Integer> primeList = getPrimeNumbers(n);
		ArrayList<Integer> factList = new ArrayList<>();
		for (int p : primeList) {
			while (n % p == 0) {
				factList.add(p);
				n /= p;
			}
			if (n == 1) break;
		}
		return factList;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder builder = new StringBuilder();
		int N = scan.nextInt();
		for(int i : getPrimeFactors(N))
			builder.append(i+"\n");
		System.out.print(builder);
	}

}
