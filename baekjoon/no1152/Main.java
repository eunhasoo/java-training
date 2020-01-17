package baekjoon.no1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine().trim();
		if (s.isEmpty()) System.out.println("0");
		else {
			String[] arr = s.split(" ");
			System.out.println(arr.length);
		}
	}

}
