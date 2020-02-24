package baekjoon.no1735;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int t1 = Integer.parseInt(st.nextToken());
		int b1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(reader.readLine());
		int t2 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		
		int top, bot;
		if (b1 != b2) { // 분모가 같지 않으면 같도록 만든 후 계산한다.
			top = t1 * b2 + t2 * b1;
			bot = b1 * b2;
		} else {
			top = t1 + t2;
			bot = b1;
		}
		
		int gcd = gcd(top, bot);
		if (gcd == 1) // 약분이 되지 않으면  그대로 출력한다.
			System.out.println(top + " " + bot);
		else {
			while(top % gcd == 0 && bot % gcd == 0) { // 둘다 약분이 되지 않을 때까지 약분하고 출력한다.
				top = top / gcd;
				bot = bot / gcd;
			}
			System.out.println(top + " " + bot);
		}
		
	}

}
