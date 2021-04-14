package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	int N, K;
	int answer = -1;
	int[] elements;
	
	void findNumber(int number) {
		if (number > N) return;
		
		if (number > answer) answer = number;
		
		for (int i = K - 1; i >= 0; i--) {
			findNumber(number * 10 + elements[i]);
		}
	}
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		elements = new int[K];
		
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < K; i++) {
			elements[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(elements);
		
		findNumber(0);
		
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
