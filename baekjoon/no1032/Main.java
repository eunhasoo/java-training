package baekjoon.no1032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		String[] fileNames = new String[N];
		for (int i = 0; i < N; i++) {
			fileNames[i] = reader.readLine();
		}

		char[] result = fileNames[0].toCharArray();
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < result.length; j++) {
				if (fileNames[i].charAt(j) != fileNames[i - 1].charAt(j)) {
					result[j] = '?';
				}
			}
		}

		System.out.println(result);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
