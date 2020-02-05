package baekjoon.no10820;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int lower, upper, number, space;
		while(scan.hasNextLine()) { // 입력이 없는 경우를 탐지하기 위해 hasNextLine 메소드 사용
			lower = upper = number = space = 0;
			String input = scan.nextLine();
			for(char c : input.toCharArray()) {
				if ((int)c >= 97 && (int)c <= 122) lower++;
				else if ((int)c >= 65 && (int)c <=90) upper++;
				else if ((int)c >= 48 && (int)c <=57) number++;
				else if ((int)c == 32) space++;
			}
			System.out.println(lower+" "+upper+" "+number+" "+space);
		}
	}

}
