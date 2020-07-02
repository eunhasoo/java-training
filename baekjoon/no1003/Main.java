package baekjoon.no1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public int[][] makeFibonacci() {
		int[][] fibonacci = new int[41][2];
		fibonacci[0][0] = fibonacci[1][1] = 1;
		// fibonacci[1][0] = fibonacci[0][1] = 0;
		for (int i = 2; i <= 40; i++) {
			fibonacci[i][0] = fibonacci[i - 1][0] + fibonacci[i - 2][0];
			fibonacci[i][1] = fibonacci[i - 1][1] + fibonacci[i - 2][1];
		}
		return fibonacci;
	}
	
	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
		int[][] fibonacci = makeFibonacci();
		int T = Integer.parseInt(reader.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(reader.readLine());
			System.out.printf("%d %d\n", fibonacci[N][0], fibonacci[N][1]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}