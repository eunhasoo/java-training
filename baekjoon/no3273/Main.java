package baekjoon.no3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		int[] seq = new int[n];
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(seq);
		
		int x = Integer.parseInt(reader.readLine());
		
		int i = 0, j = n - 1, count = 0;
		while (i < j) {
			int sum = seq[i] + seq[j];
			
			if (sum == x) {
				++count;
				j--;
				i++;
			} else if (sum > x) {
				j--;
			} else {
				i++;
			}
		}
		
		System.out.println(count);
	}

}
