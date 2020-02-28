package baekjoon.no1427;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder builder = new StringBuilder();
		String input = scan.nextLine();
		int[] numbers = new int[input.length()];
		for(int i=0; i<input.length(); i++)
			numbers[i] = input.charAt(i) - '0'; // char to int
		Arrays.sort(numbers);
		for(int i=numbers.length-1; i>=0; i--)
			builder.append(numbers[i]);
		System.out.print(builder);
	}
	
}