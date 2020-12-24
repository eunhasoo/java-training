package baekjoon.no11655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	void ROT13(String input) {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			
			if (!Character.isAlphabetic(ch)) {
				builder.append(ch);
				continue;
			}
			
			if (ch >= 'a' && ch <= 'z') {
				ch += 13;
				
				if (ch > 'z') {
					ch -= 26;
				}
			} else if (ch >= 'A' && ch <= 'Z') {
				ch += 13;
				
				if (ch > 'Z') {
					ch -= 26;
				}
			}
			
			builder.append(ch);
		}

		System.out.println(builder);
	}

	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String input = reader.readLine();

		ROT13(input);
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
