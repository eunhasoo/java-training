package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] DNAs = new String[N];
		char[] answer = new char[M];
		
		for (int i = 0; i < N; i++) {
			DNAs[i] = reader.readLine();
		}
		
		int diff = 0;
		for (int i = 0; i < M; i++) {
			char[] characters = new char[26];
			
			for (int j = 0; j < N; j++) {
				char point = DNAs[j].charAt(i);
				++characters[point - 'A'];
			}
			
			int frequency = 0, charIdx = 0;
			for (int j = 0; j < characters.length; j++) {
				if (characters[j] > frequency) {
					frequency = characters[j];
					charIdx = j;
				}
			}
			
			answer[i] = (char) (charIdx + 'A');
			diff += (N - frequency);
		}
		
		System.out.printf("%s\n%d", String.valueOf(answer), diff);
	}
}
