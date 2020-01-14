package baekjoon.no15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int arr[];
	static StringBuilder sb;
	
	public static void func(int n) {
		if(n > M) {
			for(int i=1; i<=M; i++) {
				sb.append(arr[i]+" ");
			}
			
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if (arr[n-1] != i && arr[n-1] <= i) {
				arr[n] = i;
				func(n + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M + 1];
		sb = new StringBuilder();
		func(1);
		System.out.println(sb);
	}

}
