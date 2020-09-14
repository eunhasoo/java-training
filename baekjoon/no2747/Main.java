package baekjoon.no2747;

import java.util.Scanner;

public class Main {

	public int fibonacci(int n) {
		int a = 0;
		int b = 1;
		for (int i = 2; i < n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return a + b;
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.close();
		System.out.println(fibonacci(N));
	}
	
	public static void main(String[] args) {
		new Main().run();
	}

}
