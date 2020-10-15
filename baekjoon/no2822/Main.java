package baekjoon.no2822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, Integer> scoreMap = new HashMap<>();
		int[] scores = new int[8];
		for (int number = 0; number < 8; number++) {
			int score = Integer.parseInt(reader.readLine());
			scores[number] = score;
			scoreMap.put(score, number + 1);
		}
		
		Arrays.sort(scores);
		
		int[] indexes = new int[5];
		int sum = 0, idx = 0;
		for (int i = 3; i < 8; i++) {
			sum += scores[i];
			indexes[idx++] = scoreMap.get(scores[i]);
		}
		
		Arrays.sort(indexes);
		
		StringBuilder builder = new StringBuilder();
		builder.append(sum + "\n");
		builder.append(Arrays.toString(indexes).replace("[", "").replace("]", "").replace(", ", " "));
		System.out.println(builder);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
