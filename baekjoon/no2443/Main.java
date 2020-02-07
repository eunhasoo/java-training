package baekjoon.no2443;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.valueOf(reader.readLine());
		int count = 0;
		int step = 1;
		for (int i = 0; i < N; i++) {
			for (int j = count; j < i; j++)
				sb.append(" ");
			for (int k = 0; k < 2 * N - step; k++)
				sb.append("*");
			step += 2;
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
