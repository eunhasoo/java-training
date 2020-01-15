package baekjoon.no1008;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double A = scan.nextDouble();
		double B = scan.nextDouble();
		String s = String.format("%.9f", A/B);
		System.out.println(s);
	}

}
