package baekjoon.no10808;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		// a-z까지 26개의 알파벳을 저장할 배열 생성
		int[] letters = new int[26];
		String s = scan.nextLine();
		// ASCII 코드  'a': 97 / 'A': 65
		for(char c : s.toCharArray())
			letters[(int)c - 97]++;
		for(int i=0; i<letters.length; i++)
			sb.append(letters[i]+" ");
		System.out.println(sb);
	}
}