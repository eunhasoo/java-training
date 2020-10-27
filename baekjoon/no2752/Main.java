package baekjoon.no2752;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int[] nums = new int[3];
		for (int i = 0; i < 3; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		System.out.printf("%d %d %d", nums[0], nums[1], nums[2]);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
