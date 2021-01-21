package baekjoon.no11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	StringBuilder builder = new StringBuilder();
	int moveCount = 0;
	
	public void hanoi(int N, int from, int via, int to) {
		if (N == 1) {
			++moveCount;
			builder.append(from + " " + to + "\n");
		} else {
			hanoi(N - 1, from, to, via);
			builder.append(from + " " + to + "\n");
			++moveCount;
			hanoi(N - 1, via, from, to);
		}
	}
	
	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine());
		
		hanoi(N, 1, 2, 3);
		
		System.out.println(moveCount);
		System.out.print(builder);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
