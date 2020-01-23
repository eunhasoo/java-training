package baekjoon.no1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	
	static ArrayDeque<Integer> deque= new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static int pop() {
		sb.append("-\n");
		return deque.removeLast();
	}
	
	public static void push(int i) {
		sb.append("+\n");
		deque.addLast(i);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.valueOf(reader.readLine());
		boolean isSequence = true;
		int lastPush = 0;
		int input;
		while(count-- > 0) {
			input = Integer.valueOf(reader.readLine());
			if (!isSequence) continue;
			else if (lastPush < input) {
				for(int i = lastPush + 1; i <= input; i++) 
					push(i);
				lastPush = pop();
			}
			else if (lastPush > input) {
				if (pop() != input) isSequence = false;
			}
		}
		System.out.println(isSequence ? sb : "NO");
	}

}
