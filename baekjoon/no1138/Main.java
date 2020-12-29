package baekjoon.no1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine());
		int[] heights = new int[N + 1];

		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int height = 1; height <= N; height++) {
			int left = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= N; i++) {
				if (heights[i] == 0) { // 인덱스 값이 비어 있고
					
					if (left == 0) { // 왼쪽에 키가 더 큰 사람이 없으면
						heights[i] = height; // 해당 자리에 배치
						break;
					}
					
					left--;
				}
			}
		}

		StringBuilder builder = new StringBuilder();
		for (int i = 1; i <= N; i++)
			builder.append(heights[i]).append(' ');
		System.out.print(builder);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
