package baekjoon.no11719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * BufferedReader의 readLine 메소드 Return 값 : 
		 * A String containing the contents of the line, not including any line-termination characters, 
		 * or null if the end of the stream has been reached
		 * null은 공백과는 다른 문자이므로 처리가 필요하므로 주의.
		 */
		for(int i=0; i<100; i++) {
			String s = reader.readLine();
			if (s == null) continue; // *
			System.out.println(s);
		}
	}

}