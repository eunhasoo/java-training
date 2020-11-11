package baekjoon.no10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 배열 사용
	void run_v1() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int[] cardCounts = new int[20000001];
		
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			cardCounts[number + 10000000]++;
		}
		
		int M = Integer.parseInt(reader.readLine());
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < M; i++) {
			int number = Integer.parseInt(st.nextToken());
			builder.append(cardCounts[number + 10000000]).append(" ");
		}
		
		System.out.println(builder);
	}

	// HashMap 사용
	void run_v2() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		Map<Integer, Integer> numberMap = new HashMap<>();
		
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			numberMap.put(number, numberMap.getOrDefault(number, 0) + 1);
		}
		
		int M = Integer.parseInt(reader.readLine());
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < M; i++) {
			int number = Integer.parseInt(st.nextToken());
			builder.append(numberMap.getOrDefault(number, 0) + " ");
		}
		
		System.out.println(builder);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run_v1();
	}

}
