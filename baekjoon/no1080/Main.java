package baekjoon.no1080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	int N, M, flipCount;
	int[][] A, B;
	
	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		flipCount = 0;
		
		A = new int[N][M];
		B = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String input = reader.readLine();
			for (int j = 0; j < M; j++)
				A[i][j] = input.charAt(j) - '0';
		}
		
		for (int i = 0; i < N; i++) {
			String input = reader.readLine();
			for (int j = 0; j < M; j++)
				B[i][j] = input.charAt(j) - '0';
		}
		
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (A[i][j] != B[i][j]) { // 값이 다르면 해당 인덱스를 시작으로 부분행렬을 뒤집는다
					flip(i, j);
				}
			}
		}
		
		System.out.println(isDifferent() ? -1 : flipCount);
	}
	
	public void flip(int r, int c) {
		++flipCount;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				A[i + r][j + c] = (A[i + r][j + c] == 1) ? 0 : 1;
			}
		}
	}
	
	public boolean isDifferent() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
