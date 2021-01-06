package baekjoon.no13235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static boolean isPalindrome_v1(String input) {
		int len = input.length();
		for (int i = 0; i < len / 2; i++) {
			if (input.charAt(i) != input.charAt(len - 1 - i)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String input = reader.readLine();
		
		System.out.println(isPalindrome(input));
	}

}
