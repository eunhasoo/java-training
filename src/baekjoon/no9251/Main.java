// 백준 9251

package baekjoon.no9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int LCS(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0)
			return 0;
		
		if (s1.charAt(0) == s2.charAt(0))
			return 1 + LCS(s1.substring(1), s2.substring(1));
		
		int n1 = LCS(s1, s2.substring(1));
		int n2 = LCS(s1.substring(1), s2);
		return Math.max(n1, n2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s1 = reader.readLine();
		String s2 = reader.readLine();
		System.out.println(LCS(s1, s2));
	}

}
