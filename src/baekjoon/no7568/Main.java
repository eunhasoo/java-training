// 백준 7568

package baekjoon.no7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Body {
	private int height, kg;
	
	public Body(int height, int kg) {
		this.height = height;
		this.kg = kg;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getKg() {
		return kg;
	}
}

public class Main {
	static void ranking(Body[] list) {
		for (int i=0; i<list.length; i++) {
			int rank = 0;
			for (int j=0; j<list.length; j++) {
				if (list[i].getHeight() < list[j].getHeight()
						&& list[i].getKg() < list[j].getKg())
					++rank;
			}
			System.out.printf("%d ", rank+1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		Body[] list = new Body[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int k = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			list[i] = new Body(h,k);
		}
		
		ranking(list);
	}
}
