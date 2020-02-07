package baekjoon.no2444;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = scan.nextInt();
		int count = N;
		for (int i = 1; i <= N; i++) {
			--count;
			for (int j = count; j > 0; j--)
				sb.append(" ");
			for (int k = 0; k < 2 * i - 1; k++)
				sb.append("*");
			sb.append("\n");
		}
		for (int i = N - 1; i > 0; i--) {
			++count;
			for (int j = count; j > 0; j--)
				sb.append(" ");
			for (int k = 0; k < 2 * i - 1; k++)
				sb.append("*");
			N--;
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
