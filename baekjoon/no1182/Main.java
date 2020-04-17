package baekjoon.no1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	int S;
	int[] nums;
	int count = 0;
	
	public int getCasesCount(int index, int count, int sum) {
		if (index == nums.length) {
			return (S == sum && count > 0) ? 1 : 0;
		}
		int r1 = getCasesCount(index + 1, count, sum);
		int r2 = getCasesCount(index + 1, count + 1, sum + nums[index]);
		return r1 + r2;
	}
	
	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(getCasesCount(0, 0, 0));
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
