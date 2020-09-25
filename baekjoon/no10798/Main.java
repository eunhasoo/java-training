package baekjoon.no10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = new String[5];
		for (int i = 0; i < 5; i++) {
			String s = reader.readLine();
			while (s.length() < 15) {
				s += ".";
			}
			arr[i] = s;
		}
		
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[j].charAt(i) != '.')
					builder.append(arr[j].charAt(i));
			}
		}
		
		System.out.println(builder.toString());
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
