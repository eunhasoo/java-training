// 백준 9251 -> 동적 프로그래밍 적용

package baekjoon.no9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 
	static int LCS(String s1, String s2, Integer[][] arr) {
		if (s1.length() == 0 || s2.length() == 0)
			return 0;
		Integer n = arr[s1.length() - 1][s2.length() - 1];
		if (n != null)
			return n;

		if (s1.charAt(0) == s2.charAt(0)) {
			int len = 1 + LCS(s1.substring(1), s2.substring(1), arr);
			arr[s1.length() - 1][s2.length() - 1] = len;
			return len;
		}

		int n1 = LCS(s1, s2.substring(1), arr);
		int n2 = LCS(s1.substring(1), s2, arr);
		int len = Math.max(n1, n2);
		arr[s1.length() - 1][s2.length() - 1] = len;
		return len;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s1 = reader.readLine();
		String s2 = reader.readLine();
		System.out.println(LCS(s1, s2, new Integer[s1.length()][s2.length()]));
	}

}
