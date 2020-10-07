package baekjoon.no10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public boolean binarySearch(int target, int[] cards, int startIdx, int endIdx) {	
		int midIdx = (startIdx + endIdx) / 2;
		
		if (cards[midIdx] == target) return true;
		if (endIdx == midIdx || endIdx == startIdx) return false;
		
		if (cards[midIdx] > target) {
			return binarySearch(target, cards, startIdx, midIdx);
		} else {
			return binarySearch(target, cards, midIdx + 1, endIdx);
		}
	}

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] cards = new int[N];
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cards);
		
		StringBuilder builder = new StringBuilder();
		int M = Integer.parseInt(reader.readLine());
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			int result = binarySearch(target, cards, 0, N - 1) ? 1 : 0;
			builder.append(result).append(' ');
		}
		
		System.out.print(builder.toString());
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}