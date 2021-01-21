package baekjoon.no1254;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public int palindromize(String input) {
		int len = input.length();
		for (int i = len; ; i++) {
			boolean flag = true;
			
			for (int j = 0; j < len; j++) {
				if ((i - j - 1) < len 
						&& input.charAt(j) != input.charAt(i - j - 1)) {
					flag = false;
					break;
				}
			}
			
			if (flag) return i;
		}
	}
	
	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String input = reader.readLine();
		
		System.out.println(palindromize(input));
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
