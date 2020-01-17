package baekjoon.no11721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(reader.readLine());
		while(sb.length() > 10) {
			System.out.println(sb.substring(0, 10));
			sb.delete(0, 10);
		}
		System.out.println(sb);
	}

}
