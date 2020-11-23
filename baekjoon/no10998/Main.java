package baekjoon.no10998;

import java.util.Scanner;

public class Main {

	public int isPalindrome(String input) {
		int i = input.length();
		for (int j = 0; j < input.length(); j++) {
			if (input.charAt(j) != input.charAt(i - j - 1)) {
				return 0;
			}
		}
		return 1;
	}
	
	public void run() {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		System.out.println(isPalindrome(input));
		scan.close();
	}

	public static void main(String[] args) {
		new Main().run();
	}

}
