package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine());
		
		int number = 665; // 최소 숫자인 666부터 카운트 시작
		while (N > 0) {
			++number;
			if (isSequenceNumber(number)) {
				--N;
			}
		}
		
		System.out.println(number);
	}
	
	boolean isSequenceNumber(int number) {
		int sixSeqCount = 0, maxSeqCount = 0;
		while (number > 0) {
			int lastDigit = number % 10;
			if (lastDigit == 6) ++sixSeqCount;
			else {
				maxSeqCount = Math.max(sixSeqCount, maxSeqCount);
				sixSeqCount = 0;
			}
			number /= 10;
		}
		return sixSeqCount >= 3 || maxSeqCount >= 3;
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
