package baekjoon.no13420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public void inspect(String input) {
		String[] ex = input.split(" ");
		long a = Long.parseLong(ex[0]);
		long b = Long.parseLong(ex[2]);
		long result = 0;
		if (ex[1].equals("*")) {
			result = a * b;
		} else if (ex[1].equals("/")) {
			if (b == 0) { // 0으로 나누기 항상 체크하기.......
				System.out.println("wrong answer"); return;
			}
			result = a / b;
		} else if (ex[1].equals("-")) {
			result = a - b;
		} else if (ex[1].equals("+")) {
			result = a + b;
		}

		if (result == Long.parseLong(ex[4])) {
			System.out.println("correct");
		} else {
			System.out.println("wrong answer");
		}
	}

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		while (N-- > 0) {
			String input = reader.readLine();
			inspect(input);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
