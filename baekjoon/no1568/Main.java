// 백준 1568

package baekjoon.no1568;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int singingCount = 1;
		int seconds = 0;
		while (N > 0) {
			if (N < singingCount)
				singingCount = 1;
			N -= singingCount++;
			++seconds;
		}
		System.out.println(seconds);
	}
}
