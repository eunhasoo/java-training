package baekjoon.no1934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int 최대공약수(int A, int B) {
		while(B != 0) {
			int r = A % B;
			A = B;
			B = r;
		}
		return A;
	}
	
	public static int 최소공배수(int A, int B) {
		return (A * B) / 최대공약수(A,B);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(reader.readLine());
		StringTokenizer st;
		int A, B;
		while(T-- > 0) {
			st = new StringTokenizer(reader.readLine());
			A = Integer.valueOf(st.nextToken());
			B = Integer.valueOf(st.nextToken());
			System.out.println(최소공배수(A,B));
		}
	}
	
}
