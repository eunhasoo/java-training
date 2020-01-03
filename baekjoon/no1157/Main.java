package baekjoon.no1157;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		int[] alpha = new int[26];
		for (char c : s.toUpperCase().toCharArray())
			alpha[c - 65]++;

		int max = 0, index = 0, maxCount = 0;
		for (int i = 0; i < alpha.length; i++)
			if (max < alpha[i]) {
				max = alpha[i];
				index = i;
			}
		for (int i = 0; i < alpha.length; i++)
			if (max == alpha[i])
				maxCount++;

		System.out.println(maxCount == 1 ? (char) (index + 65) : "?");

	}
}
