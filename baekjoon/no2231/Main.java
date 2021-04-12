package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int digitSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += (num % 10);
			num = num / 10;
		}
		return sum;
	}
	
	public static boolean isConstructor(int n, int N) {
		int res = n + digitSum(n);
		return (res == N);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int answer = 0;
		for (int number = N; number > 0; number--) {
			if (isConstructor(number, N)) {
				answer = number;
			}
		}
		System.out.println(answer);
	}

}
