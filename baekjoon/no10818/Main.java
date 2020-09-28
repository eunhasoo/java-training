package baekjoon.no10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			min = min > number ? number : min;
			max = max < number ? number : max;
		}
		System.out.println(min + " " + max);
	}

}