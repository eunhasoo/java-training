package baekjoon.no10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class MyQueue {
	private int[] arr;
	private int count, front, rear;

	public MyQueue(int size) {
		arr = new int[size];
		rear = -1;
		front = count = 0;
	}

	public void push(int x) {
		if (count == arr.length - 1)
			return;
		arr[++rear] = x;
		++count;
	}

	public int pop() {
		if (count == 0 || count == arr.length - 1)
			return -1;
		--count;
		return arr[front++];
	}

	public int size() {
		return count;
	}

	public int empty() {
		return (count == 0) ? 1 : 0;
	}

	public int front() {
		if (count == 0)
			return -1;
		return arr[front];
	}

	public int back() {
		if (count == 0)
			return -1;
		return arr[rear];
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.valueOf(reader.readLine());
		MyQueue queue = new MyQueue(N);
		while (N-- > 0) {
			st = new StringTokenizer(reader.readLine());
			switch (st.nextToken()) {
			case "push":
				int x = Integer.valueOf(st.nextToken());
				queue.push(x);
				break;
			case "front":
				System.out.println(queue.front());
				break;
			case "back":
				System.out.println(queue.back());
				break;
			case "pop":
				System.out.println(queue.pop());
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				System.out.println(queue.empty());
				break;
			}
		}
	}

}
