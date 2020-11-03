package baekjoon.no2920;

import java.util.Scanner;

public class Main {

	public void run() {
		Scanner scan = new Scanner(System.in);
		String[] numbers = scan.nextLine().split(" ");
		boolean ascFlag = false, descFlag = false;
		int prev = Integer.parseInt(numbers[0]);
		for (int i = 1; i < numbers.length; i++) {
			int now = Integer.parseInt(numbers[i]);
			if (prev < now) {
				ascFlag = true;
				prev = now;
				if (i > 2 && descFlag) {
					break;
				}
			} else {
				descFlag = true;
				prev = now;
				if (i > 2 && ascFlag) {
					break;
				}
			}
		}
		
		StringBuilder builder = new StringBuilder();
		if (ascFlag && descFlag) {
			builder.append("mixed");
		} else if (ascFlag) {
			builder.append("ascending");
		} else if (descFlag) {
			builder.append("descending");
		}
		
		System.out.println(builder);
	}
	
	public static void main(String[] args) {
		new Main().run();
	}

}
