package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine());
		
		int[] weights = new int[N];
		int[] heights = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			heights[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			int count = 0;
			
			for (int j = 0; j < N; j++) {
				if (heights[i] < heights[j] && weights[i] < weights[j]) {
					++count;
				}
			}
			
			System.out.printf("%d ", count + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
