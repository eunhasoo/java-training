package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;
	int[] numbers, operators;
	
	void makeNumber(int idx, int sum) {
		if (idx == numbers.length) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 0; i < operators.length; i++) {
			if (operators[i] == 0) continue;
			
			int calc = 0;
			if (i == 0) {
				calc = sum + numbers[idx];
			} else if (i == 1) {
				calc = sum - numbers[idx];
			} else if (i == 2) {
				calc = sum * numbers[idx];
			} else {
				calc = sum / numbers[idx];
			}
			
			--operators[i];
			makeNumber(idx + 1, calc);
			++operators[i];
		}
	}
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		operators = new int[4];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
		
		makeNumber(1, numbers[0]);
		
		System.out.printf("%d\n%d", max, min);
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
