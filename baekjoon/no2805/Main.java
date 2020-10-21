package baekjoon.no2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public int getMaxCutterSize(int[] heights, int M) {
		int start = 0, end = 1000000000;
		while (start + 1 < end) { // start와 end의 (정수의) 중간값이 없을 때까지 반복
			int cut = (start + end) / 2;
			
			long heightSum = 0; // int 타입은 범위 초과
			for (int i = 0; i < heights.length; i++) {
				if (cut < heights[i]) {
					heightSum += heights[i] - cut;
				}
			}

			if (M <= heightSum) {
				start = cut;
			} else {
				end = cut;
			}
		}
		
		return start;
	}

	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(st.nextToken()); // 나무의 수
		int M = Integer.parseInt(st.nextToken()); // 가져가야 하는 나무의 최소 길이
		int[] heights = new int[N];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) { // 0 ≤ input ≤ 1,000,000,000
			heights[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(getMaxCutterSize(heights, M));
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
