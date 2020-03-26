package baekjoon.no9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(reader.readLine());
		int[] cases = new int[12];
		cases[1] = 1; // 숫자 1을 만드는 경우의 수
		cases[2] = 2; // 숫자 2를 만드는 경우의 수
		cases[3] = 4; // 숫자 3을 만드는 경우의 수
		/* 1. f(N) = f(N-3) + f(N-2) + f(N-1)
		 * 2. f(4) = f(3) + f(2) + f(1)
		 * 3. f(5) = f(4) + f(3) + f(2) */
		for (int i = 4; i < cases.length; i++) {
			cases[i] = cases[i - 1] + cases[i - 2] + cases[i - 3];
		}
		for (int i = 0; i < N; i++) {
			int num = Integer.valueOf(reader.readLine());
			System.out.println(cases[num]);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}