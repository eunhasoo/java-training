package baekjoon.no11653;

import java.util.Scanner;

public class Main2 {

	static String printFactors(int n) {
		StringBuilder builder = new StringBuilder();
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				builder.append(i + "\n");
				n /= i;
			}
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		System.out.print(printFactors(N));
	}

}
