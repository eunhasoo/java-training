package baejoon.no1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[][] nums = new int[2][N];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			nums[0][i] = Integer.parseInt(st.nextToken());
		}
		
		nums[1][0] = nums[0][0];
		for (int i = 1; i < N; i++) {
			if (nums[1][i - 1] + nums[0][i] > nums[0][i]) {
				// 연속합이 입력받은 수 하나보다 큰 경우는 연속합에 수를 더하고 값을 저장 (갱신)
				nums[1][i] = nums[1][i - 1] + nums[0][i];
			} else {
				// 연속합이 입력받은 수 하나보다 작은 경우는 입력받은 수 그대로 저장 (초기화)
				nums[1][i] = nums[0][i];
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if (max < nums[1][i])
				max = nums[1][i];
		}
		
		System.out.println(max);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
