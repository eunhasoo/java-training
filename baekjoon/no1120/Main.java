package baekjoon.no1120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		String s1 = st.nextToken();
		String s2 = st.nextToken();
		
		int offset = s2.length() - s1.length();
		
		int min = 50;
		for (int i = 0; i <= offset; i++) {
			int count = 0;
			for (int j = 0; j < s1.length(); j++) {
				if (s1.charAt(j) != s2.charAt(i + j)) ++count;
			}
			min = Math.min(count, min);
		}
		
		System.out.println(min);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
