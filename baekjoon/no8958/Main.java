package baekjoon.no8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public int getTotalScore(String result) {
		int count = 0, totalScore = 0;
		for (char score : result.toCharArray()) {
			if (score == 'O') {
				++count;
				totalScore += count;
				continue;
			}
			count = 0;
		}
		return totalScore;
	}

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		while (N-- > 0) {
			System.out.println(getTotalScore(reader.readLine()));
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
