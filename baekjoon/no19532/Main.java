package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static final int MIN = -999;
	static final int MAX = 999;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int a, b, c, d, e, f;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
	
		boolean found = false;
		for (int x = MIN; x <= MAX; x++) {
			for (int y = MIN; y <= MAX; y++) {
				if ((a * x + b * y == c) && (d * x + e * y == f)) {
					System.out.println(x + " " + y);
					found = true;
					break;
				}
			}
			if (found) break;
		}
	}

}
