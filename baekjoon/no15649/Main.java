package baekjoon.no15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int arr[];
	static boolean hasExisted[];
	static StringBuilder sb;

	public static void func(int n) {
		if (n > M) {
			for (int i = 1; i <= M; i++) {
				sb.append(arr[i] + " ");
			}

			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!hasExisted[i]) {
				arr[n] = i;
				hasExisted[i] = true;
				func(n + 1);
				// 재귀호출 실행 종료후 돌아올 때마다 비교용 배열의 상태를 원래대로 복구한다.
				hasExisted[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[9];
		hasExisted = new boolean[9];
		sb = new StringBuilder();
		func(1);
		System.out.println(sb);
	}

}
