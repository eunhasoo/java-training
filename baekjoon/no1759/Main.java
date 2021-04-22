package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	int L, C;
	char[] alpha;
	StringBuilder builder = new StringBuilder();
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new char[C];
		
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha);
		
		createCode(0, "");
		
		System.out.print(builder);
	}
	
	void createCode(int idx, String code) {
		if (code.length() == L) {
			if (isValid(code)) {
				builder.append(code).append("\n");
			}
			return;
		}
		
		for (int i = idx; i < C; i++) {
			createCode(i + 1, code + alpha[i]);
		}
	}
	
	boolean isValid(String code) {
		int vowel = 0; // 모음 수 
		int consonant = 0; // 자음 수
		for (int i = 0; i < code.length(); i++) {
			char c = code.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ++vowel;
			else ++consonant;
		}
		return vowel >= 1 && consonant >= 2;
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
