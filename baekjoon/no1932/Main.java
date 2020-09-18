package baekjoon.no1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public int getMaxSum(int[][] triangle, int N) {
		for (int i = 1; i < triangle.length; i++) {
			for (int j = 1; j < triangle[i].length; j++) {
				triangle[i][j] = Math.max(triangle[i][j] + triangle[i - 1][j - 1], 
						triangle[i][j] + triangle[i - 1][j]);
			}
		}
		
		int max = 0;
		for (int i = 0; i < triangle[N].length; i++) {
			if (max < triangle[N][i])
				max = triangle[N][i];
		}
		return max;
	}

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[][] triangle = new int[N + 1][N + 1];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(reader.readLine());
			int idx = 1;
			while (st.hasMoreTokens()) {
				triangle[i][idx++] = Integer.parseInt(st.nextToken());
			}
		}

		if (N == 1) {
			System.out.println(triangle[N][N]);
		} else {
			System.out.println(getMaxSum(triangle, N));
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
