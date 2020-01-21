package baekjoon.no9093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		ArrayDeque<Character> queue = new ArrayDeque<>();
		while(N-- > 0) {
			StringBuilder sb = new StringBuilder();
			String s = reader.readLine() + "\n"; 
			// readLine은 줄바꿈을 만나면 그대로 읽기를 끝내므로 \n를 따로 뒤에 붙여주어야 한다
			for(char c : s.toCharArray()) {
				if (c == ' ' || c == '\n' || c == '\r') {
					while(queue.size() > 0)
						sb.append(queue.removeLast());
					sb.append(c); // 단어 추가를 끝낸뒤 공백문자를 추가한다
				}
				else queue.addLast(c);
			}
			System.out.print(sb);
		}
	}

}
