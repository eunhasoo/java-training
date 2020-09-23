package baekjoon.no2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public int getWordCount(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			++count;

			if (s.length() - 1 <= i) {
				continue;
			}

			char c = s.charAt(i);
			if (c == 'd') {
				if (s.charAt(i + 1) == '-') {
					++i;
				} else if (s.length() - 2 > i && s.charAt(i + 1) == 'z' && s.charAt(i + 2) == '=') {
					i += 2;
				}
				continue;
			} else if (c == 'c' && (s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-')) {
				++i;
				continue;
			} else if (c == 'l' && s.charAt(i + 1) == 'j') {
				++i;
				continue;
			} else if (c == 'n' && s.charAt(i + 1) == 'j') {
				++i;
				continue;
			} else if (c == 'z' && s.charAt(i + 1) == '=') {
				++i;
				continue;
			} else if (c == 's' && s.charAt(i + 1) == '=') {
				++i;
				continue;
			}
		}

		return count;
	}

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(getWordCount(reader.readLine()));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
