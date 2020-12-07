package baekjoon.no2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int[] heights = new int[9];
		
		// 키를 초과하는 난쟁이들을 찾기 위한 변수
		// 난쟁이들의 키의 총합인 100을 뺀 상태로 초기화
		int over = -100; 
		
		for (int i = 0; i < 9; i++) {
			heights[i] = Integer.parseInt(reader.readLine());
			over += heights[i];
		}
		
		Arrays.sort(heights);
		
		boolean found = false;
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				// 두 난쟁이의 키의 합이 over값과 같은 경우 -1으로 갱신 후 반복을 끝냄
				if (heights[i] + heights[j] == over) {
					heights[i] = -1;
					heights[j] = -1;
					found = true;
					break;
				}
			}
			
			if (found) break;
		}

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			if (heights[i] < 0) continue;
			builder.append(heights[i]).append("\n");
		}
		System.out.print(builder);
	}

}
