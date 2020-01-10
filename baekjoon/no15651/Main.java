package baekjoon.no15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb;
	
	public static void func(int n) {
		if (n == M) {
			for(int i=0; i<M; i++)
				sb.append(arr[i]+" ");
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			arr[n] = i;
			func(n + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[8];
		func(0);
		System.out.println(sb);
	}

}
