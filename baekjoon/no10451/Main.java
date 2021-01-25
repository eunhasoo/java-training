package baekjoon.no10451;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	int[] sequence;
	boolean[] visited;
	int cycleCount;
	
	public void search(int num) {
		visited[num] = true;
		
		if (visited[sequence[num]]) {
			++cycleCount;
			return;
		}
		
		search(sequence[num]);
	}
	
	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(reader.readLine());
			
			sequence = new int[N + 1];
			visited = new boolean[N + 1];
			cycleCount = 0;
			
			StringTokenizer st = new StringTokenizer(reader.readLine());
			
			for (int num = 1; num <= N; num++) {
				sequence[num] = Integer.parseInt(st.nextToken());
			}
			
			for (int num = 1; num <= N; num++) {
				if (!visited[num]) {
					search(num);
				}
			}
			
			System.out.println(cycleCount);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
