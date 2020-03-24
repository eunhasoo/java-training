package baekjoon.no9020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	boolean[] prime = new boolean[10001];

	public void makePrimeNumberList() {
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int i = 2; (i * i) <= prime.length - 1; i++)
			if (prime[i])
				for (int j = i * 2; j <= prime.length - 1; j += i)
					prime[j] = false;
	}

	public void start() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.valueOf(reader.readLine());
		makePrimeNumberList();
		while (loop-- > 0) {
			int evenNum = Integer.valueOf(reader.readLine());
			int up, down;
			up = down = evenNum / 2;
			while (true) {
				if (prime[up] && prime[down]) {
					System.out.println(down + " " + up);
					break;
				}
				++up;
				--down;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Main m = new Main();
		m.start();
	}

}
