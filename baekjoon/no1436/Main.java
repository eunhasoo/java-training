package baekjoon.no1436;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		int count = 0;
		int answer = 0;
		int number = 665;
		while (count != N) {
			++number;
			if ((number + "").contains("666")) {
				++count;
				answer = number;
			}
		}
		
		System.out.println(answer);
	}

}
