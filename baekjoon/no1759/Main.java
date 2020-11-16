package baekjoon.no1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	int L, C;
	char[] alpha;
	StringBuilder builder = new StringBuilder();
	
	boolean isVowels(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}
	
	void backTracking(int idx, String code, int consonant, int vowel) {
		if (code.length() == L) {
			// 최소 두 개의 자음과 한 개의 모음으로 구성됐는지 체크
			if (consonant < 2 || vowel < 1) { 
				return;
			}
			
			builder.append(code).append("\n");
		}
		
		for (int i = idx; i < C; i++) {
			if (isVowels(alpha[i])) {
				backTracking(i + 1, code + alpha[i], consonant, vowel + 1);
			} else {
				backTracking(i + 1, code + alpha[i], consonant + 1, vowel);
			}
		}
	}
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		L = Integer.parseInt(st.nextToken()); // 암호가 될 문자 개수
		C = Integer.parseInt(st.nextToken()); // 입력 문자 개수
		alpha = new char[C];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpha); // 암호는 알파벳 순서대로 배열된다
		
		backTracking(0, "", 0, 0);
		
		System.out.print(builder.toString());
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
