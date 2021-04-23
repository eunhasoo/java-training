package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	int solution(double X, double Y) {
		double Z = Math.floor((Y * 100) / X); // 현재 승률
		
		if (Z >= 99) { // 승률이 절대 변하지 않음
			return -1;
		}
		
		int start = 0;
		int end = (int) X;
		while (end >= start) {
			int mid = (start + end) / 2;
			double temp = Math.floor(((Y + (double) mid) / (X + (double) mid)) * 100);

			if (temp > Z) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return start;
	}
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		double X = Double.parseDouble(st.nextToken());
		double Y = Double.parseDouble(st.nextToken());
		
		System.out.println(solution(X, Y));
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
