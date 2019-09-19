package baekjoon.no1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		List<String> wordList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String s = reader.readLine();
			if (!wordList.contains(s))
				wordList.add(s);
		}

		Collections.sort(wordList, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int slength = s1.length() - s2.length();
				if (slength != 0) {
					return slength;
				}
				return s1.compareTo(s2);
			}
		});

		for (int i = 0; i < wordList.size(); i++) {
			System.out.println(wordList.get(i));
		}
	}
}
