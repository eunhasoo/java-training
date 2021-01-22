package baekjoon.no1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	int r, c;
	int count = 0;
	
	public void search(int n, int row, int col) {
		if (row == r && col == c) {
			System.out.println(count);
			System.exit(0);
		}
		
		if (r < (row + n) && r >= row 
				&& c < (col + n) && c >= col) { // n x n을 4분면으로 나눈 내부에 (r,c)가 포함
			search(n / 2, row, col); // 1분면 탐색
			search(n / 2, row, col + n / 2); // 2분면 탐색
			search(n / 2, row + n / 2, col); // 3분면 탐색
			search(n / 2, row + n / 2, col + n / 2); // 4분면 탐색
		} else { // 탐색할 가치가 없거나 (r,c)가 있는 분면의 내부 칸들
			count += n * n;
		}
	}
	
	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		search(N, 0, 0);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
