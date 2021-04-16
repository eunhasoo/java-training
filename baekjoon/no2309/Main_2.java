package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	int[] heights = new int[9];
	boolean[] checked = new boolean[9];
	
	void dfs(int idx, int count, int sum) {
		if (sum > 100) return;
		
		if (count == 7) {
			if (sum != 100) return;
			
			print();
			System.exit(0); // 작업을 여기서 끝낸다.
		}
		
		for (int i = idx; i < 9; i++) {
			if (!checked[i]) {
				checked[i] = true;
				dfs(idx + 1, count + 1, sum + heights[i]);
				checked[i] = false;
			}
		}
	}
	
	void print() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			if (checked[i]) {
				builder.append(heights[i] + "\n");
			}
		}
		System.out.print(builder);
	}
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			heights[i] = Integer.parseInt(reader.readLine());
		}

		Arrays.sort(heights);
		
		dfs(0, 0, 0);
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
