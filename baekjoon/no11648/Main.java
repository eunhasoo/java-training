package baekjoon.no11648;

import java.util.Scanner;

public class Main {

	int getSteps(int number) {
		int step = 0;
		while (true) {
			if (number < 10) break;
			
			int cal = 1;
			while (number > 0) {
				cal *= (number % 10);
				number /= 10;
			}
			step++;
			
			number = cal;
		}
		return step;
	}
	
	void run() {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		System.out.println(getSteps(number));
	}
	
	public static void main(String[] args) {
		new Main().run();
	}

}
