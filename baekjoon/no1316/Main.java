// 백준 1316

package baekjoon.no1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean isGroupWord(String s) {
		for (int i = 0; i < s.length() - 2; i++)
			for (int j = i + 2; j < s.length(); j++)
				if (s.charAt(i) == s.charAt(j) && s.charAt(i) != s.charAt(i + 1))
					return false;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		String inputWord = "";
		int wordCount = 0;
		for (int i = 0; i < N; i++) {
			inputWord = reader.readLine().toLowerCase();

			if (inputWord.length() < 3 && inputWord.length() != 0)
				wordCount++;
			else if (isGroupWord(inputWord))
				wordCount++;
		}
		System.out.println(wordCount);

	}
}
