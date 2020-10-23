package baekjoon.no4796;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int caseCount = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int L = Integer.parseInt(st.nextToken()); // 연속 기간 중에 캠프장 사용 가능 기간
			int P = Integer.parseInt(st.nextToken()); // 연속 기간
			int V = Integer.parseInt(st.nextToken()); // 휴가 기간
			
			if (L == 0 && P == 0 && V == 0) break;
			
			int campingDay = 0;
			while (P < V) {
				campingDay += L;
				V = V - L - (P - L);
			}
			campingDay = (V > L) ? campingDay + L : campingDay + V;
			
			System.out.printf("Case %d: %d\n", caseCount++, campingDay);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
