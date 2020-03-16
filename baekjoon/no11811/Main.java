package baekjoon.no11811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.valueOf(reader.readLine());
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			while(st.hasMoreTokens()) {
				int num = Integer.valueOf(st.nextToken());
				answer[i] = answer[i] | num;
			}
		}
		for(int i=0; i<n; i++) {
				System.out.printf("%d ", answer[i]);
		}
	}

}
