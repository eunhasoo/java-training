package baekjoon.no1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		
		StringTokenizer st;
		String plusOp = "";
		int minus = 0, plus = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			
			// 첫 '-'를 만나면 이후 나오는 숫자들을 모두 더해 minus 변수에 저장하고 반복을 끝낸다
			// ex. 7+6-5+9-10 --> -(5+9+10)
			if (c == '-') { 
				st = new StringTokenizer(input.substring(i + 1).replaceAll("[+-]", " "));
				while (st.hasMoreTokens())
					minus += Integer.parseInt(st.nextToken());
				
				break;
			}
			
			// '-'를 만나기 전까지의 문자들을 문자열을 저장한다
			// ex. 7+6-5+9-10 --> 7+6
			plusOp += c;
		}
		
		// '-'를 만나기 전까지 저장해둔 문자열에서 [부호를 제외한] 숫자들을 모두 더해 plus 변수에 저장한다
		st = new StringTokenizer(plusOp, "+");
		while (st.hasMoreTokens())
			plus += Integer.parseInt(st.nextToken());
		
		System.out.println(plus - minus);
		
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
