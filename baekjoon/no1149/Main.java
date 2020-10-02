package baekjoon.no1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public int getMinCost(int[][] costs) {
		int len = costs.length;
		for (int i = 1; i < len; i++) {
			costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]); // R -> G or B
			costs[i][1] += Math.min(costs[i - 1][2], costs[i - 1][0]); // G -> R or B
			costs[i][2] += Math.min(costs[i - 1][1], costs[i - 1][0]); // B -> R or G
		}
		return Math.min(costs[len - 1][0], Math.min(costs[len - 1][1], costs[len - 1][2]));
	}
	
	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[][] costs = new int[N][3];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; st.hasMoreTokens(); j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(getMinCost(costs));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
