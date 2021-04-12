package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int K;

	public static boolean hasNumber(int number) {
		if (K == 0) { // K가 0인 경우에는 0시/0분/0초인 경우를 잡아줘야 한다.
			if (number < 10) return true;
		}
		
		while (number > 0) {
			if (number % 10 == K) return true;
			number /= 10;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int count = 0;
		for (int hour = 0; hour <= N; hour++) {
			for (int min = 0; min < 60; min++) {
				for (int sec = 0; sec < 60; sec++) {
					if (hasNumber(hour) || hasNumber(min) || hasNumber(sec)) {
						++count;
					}
				}
			}
		}
		System.out.println(count);
	}

}
