package baekjoon.no2748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public long[] makeFibonacci() {
		long[] fibonacci = new long[91];
		fibonacci[1] = fibonacci[2] = 1;
		for (int i = 3; i < fibonacci.length; i++) {
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}
		return fibonacci;
	}
	
	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
		long[] fibonacci = makeFibonacci();
		int N = Integer.parseInt(reader.readLine());
		System.out.println(fibonacci[N]);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}
}
