package baekjoon.no2193;

import java.util.Scanner;

public class Main {

	public void run() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); 
		long a, b, answer; // // N의 범위(1 ≤ N ≤ 90)가 문제 포인트!!!
		a = b = answer = 1;
		for (int i = 3; i <= N; i++) {
			answer = a + b;
			a = b;
			b = answer;
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) {
		new Main().run();
	}

}
