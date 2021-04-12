package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int A = Integer.parseInt(reader.readLine()); // 플레이어 A명
		int T = Integer.parseInt(reader.readLine()); // T번째
		String word = reader.readLine(); 	     // 구호 (0: 뻔, 1: 데기)
		
		int count = 0;
		int repeat = 2;
		int pointer = 0; // 이전 체크 인덱스 이후부터 체크하기 위한 변수
		String start = "0101";
		while (true) {
			// 뻔데기 붙이기 작업
			builder.append(start);
			for (int i = 0; i < repeat; ++i) {
				builder.append("0");
			}
			for (int i = 0; i < repeat; ++i) {
				builder.append("1");
			}
			
			// 구호 카운트 체크
			boolean found = false;
			for (int i = pointer; i < builder.length(); i++) {
				if (builder.charAt(i) == word.charAt(0)) {
					++count;
					
					// T번째 구호 찾음
					if (count == T) {
						pointer = i;
						found = true;
						break;
					}
				}
			}
			
			if (found) { // 출력 후 종료한다.
				System.out.println(pointer % A);
				break;
			}
			
			// 포인터, 반복 값 갱신
			pointer = builder.length();
			++repeat;
		}
	}

}
