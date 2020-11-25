package baekjoon.no14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	int[] sequence;
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;
	
	void makeNumber(int idx, int number, int plus, int minus, int mul, int div) {
		if (idx == sequence.length - 1) {
			min = Math.min(min, number);
			max = Math.max(max, number);
			return;
		}
		
		if (idx < sequence.length - 1) {
			if (plus > 0) {
				makeNumber(idx + 1, number + sequence[idx + 1], plus - 1, minus, mul, div);
			}
			if (minus > 0) {
				makeNumber(idx + 1, number - sequence[idx + 1], plus, minus - 1, mul, div);
			}
			if (mul > 0) {
				makeNumber(idx + 1, number * sequence[idx + 1], plus, minus, mul - 1, div);
			}
			if (div > 0) {
				makeNumber(idx + 1, number / sequence[idx + 1], plus, minus, mul, div - 1);
			}
		}
	}

	void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		sequence = new int[N];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; st.hasMoreTokens(); i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(reader.readLine());
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int mul = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());
		
		makeNumber(0, sequence[0], plus, minus, mul, div);
		System.out.printf("%d\n%d", max, min);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
