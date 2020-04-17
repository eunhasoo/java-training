package baekjoon.no2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		ArrayList<Integer> nums = new ArrayList<>();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(reader.readLine());
			nums.add(num);
		}
		Collections.sort(nums);
		/* Arrays.sort는 quick sort를 구현해서 최악의 경우 O(n^2)의 수행 시간이 걸린다.
		     따라서 수행시간이 O(nlogn)인 merge sort를 구현한 Collections.sort를 사용해야 한다. */
		for(int num : nums)
			builder.append(num+"\n");
		System.out.print(builder.toString());
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
