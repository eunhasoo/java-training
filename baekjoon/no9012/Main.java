package baekjoon.no9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int checkVPS(String s) {
		int count = 0;
		for(char c : s.toCharArray()) {
			if (c == '(') ++count;
			if (c == ')') --count;
			if (count < 0) return -1;
		}
		return count;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(reader.readLine());
		while (n-- > 0)
			System.out.println((checkVPS(reader.readLine()) == 0)? "YES" : "NO");
	}
}
