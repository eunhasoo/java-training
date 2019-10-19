package baekjoon.no1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		while(N > 0) {
			int n = Integer.parseInt(reader.readLine());
			int[] a = new int[n + 1];
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(reader.readLine());
				int index = Integer.parseInt(st.nextToken());
				a[index] = Integer.parseInt(st.nextToken());
			}
			int count = 1;
			int min=a[1];
			for(int i=2; i<a.length; i++) {
				if (a[i] < min) {
					count++;
					min = a[i];
				}
			}
			System.out.println(count);
			--N;
		}

	}

}
