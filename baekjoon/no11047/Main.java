package baekjoon.no11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		int[] values = new int[N];
		for (int i = 0; i < N; i++) {
			values[i] = Integer.valueOf(reader.readLine());
		}
		int count = 0;
		for (int i = values.length - 1; i >= 0; i--) {
			while((K - values[i]) >= 0) {
				K -= values[i];
				++count;
			}
			if (K == 0) {
				break;
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.run();
	}

}
