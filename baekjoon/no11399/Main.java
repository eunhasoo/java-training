package baekjoon.no11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(reader.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);
		int min = 0;
		for(int i=0; i<arr.length; i++)
			for(int j=0; j<=i; j++) {
				min += arr[j];
			}
		System.out.println(min);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Main m = new Main();
		m.run();
	}

}
