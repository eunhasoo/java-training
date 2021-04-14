package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 1-3, 1-2와 같이 중복인 경우가 있으므로 2차원 배열에 저장한다.
		int[][] doNotMix = new int[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(reader.readLine());
			
			int typeA = Integer.parseInt(st.nextToken());
			int typeB = Integer.parseInt(st.nextToken());
			
			doNotMix[typeA][typeB] = doNotMix[typeB][typeA] = 1;
		}
		
		int answer = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (doNotMix[i][j] > 0) continue;
				
				for (int k = j + 1; k <= N; k++) {
					if (doNotMix[i][k] > 0 || doNotMix[j][k] > 0) continue;
					++answer;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
