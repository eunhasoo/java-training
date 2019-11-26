// 백준 1018

package baekjoon.no1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] wfBoard, bfBoard, inputBoard;

	static int check(int x, int y) {
		int whiteCount = 0, blackCount = 0;

		for (int i = x; i < x + 8; i++)
			for (int j = y; j < y + 8; j++) {
				if (inputBoard[i][j] != wfBoard[i - x][j - y])
					whiteCount++;
				if (inputBoard[i][j] != bfBoard[i - x][j - y])
					blackCount++;
			}

		return Math.min(whiteCount, blackCount);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		inputBoard = new char[N][M];
		wfBoard = new char[N][M];
		bfBoard = new char[N][M];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				int flag = (i + j) % 2;
				wfBoard[i][j] = (flag == 0) ? 'W' : 'B';
				bfBoard[i][j] = (flag == 0) ? 'B' : 'W';
			}
		}
		for (int i = 0; i < N; i++) {
			String s = reader.readLine();
			for (int j = 0; j < M; j++) {
				inputBoard[i][j] = s.charAt(j);
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i + 7 < N; i++)
			for (int j = 0; j + 7 < M; j++)
				result = Math.min(result, check(i, j));
		System.out.println(result);
	}

}
