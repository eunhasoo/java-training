// 백준 3460

package baekjoon.no3460;

import java.util.Scanner;

public class Main {
	public static void bitCount(int x, int count) {
		if (x == 0)
			return;

		int bit = x % 2;
		if (bit == 1)
			System.out.printf("%d ", count);
		count++;

		bitCount(x / 2, count);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for (int i = 0; i < N; i++) {
			int x = scan.nextInt();
			bitCount(x, 0);
			System.out.println();
		}
	}

}