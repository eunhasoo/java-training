package baekjoon.no10809;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		int[] letters = new int[26];
		for(int i=0; i<letters.length; i++)
			letters[i] = -1;
		int num = 0;
		for(char c : s.toCharArray()) {
			int index = (int)c - 97;
			if (letters[index] == -1)
				letters[index] = num;
			num++;
		}
		for(int i=0; i<letters.length; i++)
			System.out.printf("%d ", letters[i]);
	}

}
