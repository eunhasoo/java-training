// 백준 11720

package baekjoon.no11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		String s = reader.readLine();
		int sum = 0;
		for(int i=0; i<N; i++)
			sum += s.charAt(i)-'0';
		System.out.println(sum);
	}
}
