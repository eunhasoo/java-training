package baejoon.no11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public int LIS(int[] seq) {
		int[] dp = new int[seq.length];
		for (int i = 0; i < seq.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (seq[i] > seq[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			if (max < dp[i]) max = dp[i];
		}
		return max;
	}
	
	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] sequence = new int[N];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(LIS(sequence));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
