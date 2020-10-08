package baekjoon.no6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	StringBuilder builder = new StringBuilder();
	int[] rotto;
	int count;
	
	public void printNumber(int index, String s) {
		if (count == 6) {
			builder.append(s + "\n");
		} else {
			for (int i = index + 1; i < rotto.length; i++) {
				++count;
				printNumber(i, s + rotto[i] + " ");
			}
		}
		
		--count;
	}
	
	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(st.nextToken());
			if (n == 0) // 종료조건
				break;
			
			rotto = new int[n];
			for (int i = 0; i < n; i++) {
				rotto[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i <= n - 6; i++) {
				count = 1;
				printNumber(i, rotto[i] + " ");
			}
			
			builder.append("\n");
		}
		
		System.out.println(builder.toString());
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
