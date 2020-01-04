package baekjoon.no1110;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int firstNumber = N;
		int onesPlace;
		int tensPlace;
		int count = 0;
		while (true) {
			int a = N / 10;
			int b = N % 10;
			onesPlace = (a + b) % 10;
			tensPlace = b * 10;
			N = onesPlace + tensPlace;
			count++;
			if (N == firstNumber) break;
		}
		System.out.println(count);
		scan.close();
	}

}
