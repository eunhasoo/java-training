package baekjoon.no2576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int oddMin = Integer.MAX_VALUE, oddSum = 0;
		for (int i = 0; i < 7; i++) {
			int number = Integer.parseInt(reader.readLine());
			
			if (number % 2 == 0) continue;
			
			oddMin = Math.min(number, oddMin);
			oddSum += number;
		}

		if (oddSum == 0) {
			System.out.println(-1);
		} else {
			System.out.printf("%d\n%d", oddSum, oddMin);
		}
	}

}
