package baekjoon.no5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int[] buttons = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 
				8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};
		
		String input = reader.readLine();
		
		int sec = 0;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				sec += buttons[ch - 'A'];
		}
		
		System.out.println(sec);
	}

}
