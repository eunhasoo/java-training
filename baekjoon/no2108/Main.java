package baekjoon.no2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());

		if (N == 1) {
			int n = Integer.parseInt(reader.readLine());
			System.out.println(n);
			System.out.println(n);
			System.out.println(n);
			System.out.println(0);
		} else {
			
			List<Integer> numbers = new ArrayList<>();
			int[] frequency = new int[8001];
			
			for(int i = 0; i < N; i++) {
				int n = Integer.parseInt(reader.readLine());
				frequency[n + 4000]++;
				numbers.add(n);
			}
			
			Collections.sort(numbers);
			
			int min = numbers.get(0);
			int max = numbers.get(numbers.size() - 1);
			
			// 산술평균
			double arithmeticMean = 0;
			for (int i = 0; i < numbers.size(); i++)
				arithmeticMean += numbers.get(i);
			arithmeticMean = Math.round(arithmeticMean / N);
			
			// 최빈값
			int mode = 0;
			int maxFrequency = 1, count = 0;
			for (int i = min; i <= max; i++) { // 최대 빈도수 구하기
				if (maxFrequency <= frequency[i + 4000]) {
					maxFrequency = frequency[i + 4000];
				}
			}
			for (int i = min; i <= max; i++) { // 최대 빈도가 여럿인 경우 두 번째로 작은 수 구하기
				if (maxFrequency <= frequency[i + 4000]) {
					maxFrequency = frequency[i + 4000];
					mode = i;
					++count;
				}
				
				if (count == 2) break;
			}
			
			int median = numbers.get(numbers.size() / 2); // 중앙값
			int range = max - min; // 범위

			System.out.printf("%.0f\n%d\n%d\n%d", arithmeticMean, median, mode, range);
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
