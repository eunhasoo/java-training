package baekjoon.no2164;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		
		int N = scan.nextInt();
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while (queue.size() > 2) {
			queue.remove();
			queue.add(queue.remove());
		}
		
		System.out.println(queue.peekLast());
	}

}
