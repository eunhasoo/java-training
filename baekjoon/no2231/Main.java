// 백준 2231

package baekjoon.no2231;

import java.util.Scanner;

public class Main {
	static int digitSum(int n) {
		int result = 0;
		while (n > 0) {
			result += n % 10;
			n /= 10;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int n = N, digitCount = 0;
		while(n != 0) {
			n /= 10;
			digitCount++;
		}
		int startNum = N - digitCount * 9;
		int answer = 0;
		for(int i=startNum; i<=N; i++) {
			if (i + digitSum(i) == N) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}

}
