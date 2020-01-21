package baekjoon.no10872;

import java.util.Scanner;

public class Main {

	// 재귀함수로 구현
	public static int factorial(int n) {
		if (n <= 1) return 1;
		return n * factorial(n-1);
	}
	
	// 반복문으로 구현
	public static int factorial2(int n) {
		int fac = 1;
		for(int i=1; i<=n; i++)
			fac *= i;
		return fac;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		System.out.println(factorial(N));
		// System.out.println(factorial2(N));
	}

}
