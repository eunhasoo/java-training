package baekjoon.no3036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.valueOf(reader.readLine());
		int[] radiusList = new int[N];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for(int i=0; st.hasMoreTokens(); i++)
			radiusList[i] = Integer.valueOf(st.nextToken());
		for(int i=1; i<N; i++) {
			int gcd = gcd(radiusList[0], radiusList[i]);
			int top = radiusList[0] / gcd;
			int bot = radiusList[i] / gcd;
			sb.append(top+"/"+bot+"\n");
		}
		System.out.print(sb);
	}

}
