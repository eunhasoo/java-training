package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	int N, M;
	int[][] favor;
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 회원 수
		M = Integer.parseInt(st.nextToken()); // 치킨 종류
		
		favor = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < M; j++) {
				favor[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		int maxFavor = 0;
		// 치킨 종류 선택
		for (int i = 0; i < M - 2; i++) {
			for (int j = i + 1; j < M - 1; j++) {
				for (int k = j + 1; k < M; k++) {
					// 선호도 합 최대값 갱신
					maxFavor = Math.max(maxFavor, sum(i, j, k));
				}
			}
		}
		System.out.println(maxFavor);
	}
	
	int sum(int i, int j, int k) {
		int sum = 0;
		for (int n = 0; n < N; n++) {
			sum += Math.max(Math.max(favor[n][i], favor[n][j]), favor[n][k]);
		}
		return sum;
	}
	
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
