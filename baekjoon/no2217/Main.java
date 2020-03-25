package baekjoon.no2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(reader.readLine());
		Integer[] weights = new Integer[N];
		for (int i = 0; i < N; i++) {
			weights[i] = Integer.valueOf(reader.readLine());
		}
		Arrays.sort(weights);
		int max = 0;
		int lopeNum = N;
		for (int i = 0; i < N; i++) {
			max = Math.max(weights[i] * lopeNum, max);
			--lopeNum;
		}
		System.out.println(max);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Main m = new Main();
		m.run();
	}

}
