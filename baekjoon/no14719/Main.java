package baekjoon.no14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] blocks = new int[H][W];
		
		st = new StringTokenizer(reader.readLine());
		int width = 0;
		while (st.hasMoreTokens()) {
			int height = Integer.parseInt(st.nextToken()) - 1;
			if (height < 0) {
				++width;
				continue;
			}
			
			for (int i = 0; i <= height; i++) {
				blocks[i][width]++;
			}
			
			++width;
		}
		
		int total = 0;
		for (int i = 0; i < blocks.length; i++) {
			boolean flag = false;
			int water = 0;
			
			for (int j = 0; j < blocks[i].length; j++) {
				if (blocks[i][j] == 1) {
					if (water == 0) {
						flag = true;
					} else {
						total += water;
						water = 0;
					}
				}
				
				if (flag && blocks[i][j] == 0) {
					water++;
				}
			}
		}
		
		System.out.println(total);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
