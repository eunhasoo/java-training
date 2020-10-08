package baekjoon.no10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> stack = new ArrayDeque<>();
		int K = Integer.parseInt(reader.readLine());
		int sum = 0;
		while (K-- > 0) {
			int n = Integer.parseInt(reader.readLine());
			if (n == 0) {
				sum -= stack.pop();
				continue;
			}
			stack.push(n);
			sum += n;
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
