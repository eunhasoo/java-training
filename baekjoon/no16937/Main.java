package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	int H, W;

	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(reader.readLine());
		int[][] stickers = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(reader.readLine());

			stickers[i][0] = Integer.parseInt(st.nextToken());
			stickers[i][1] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			int r1 = stickers[i][0];
			int c1 = stickers[i][1];

			for (int j = i + 1; j < N; j++) {
				int r2 = stickers[j][0];
				int c2 = stickers[j][1];

				if (isPossibleToStick(r1, c1, r2, c2)) {
					answer = Math.max(answer, r1 * c1 + r2 * c2);
				}
			}
		}
		System.out.println(answer);
	}

	boolean checkTheArea(int r1, int c1, int r2, int c2) {
		if (r1 + r2 <= H && Math.max(c1, c2) <= W) { // 세로로 이어 붙이는 경우
			return true;
		}
		if (c1 + c2 <= W && Math.max(r1, r2) <= H) { // 가로로 이어 붙이는 경우
			return true;
		}
		return false;
	}

	boolean isPossibleToStick(int r1, int c1, int r2, int c2) {
		if (checkTheArea(r1, c1, r2, c2)) { // 회전X 회전X
			return true; 
		}
		if (checkTheArea(r1, c1, c2, r2)) { // 회전X 회전O
			return true; 
		}
		if (checkTheArea(c1, r1, r2, c2)) { // 회전O 회전X
			return true;  
		}
		if (checkTheArea(c1, r1, c2, r2)) { // 회전O 회전O
			return true; 
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
