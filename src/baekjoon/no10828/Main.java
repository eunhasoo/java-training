// 백준 10828

package baekjoon.no10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Stack {
		int[] a;
		int top = -1, count = 0;

		public Stack(int size) {
			a = new int[size];
		}

		public void push(int x) {
			if (count < a.length) {
				a[++top] = x;
				count++;
			}
		}

		public int pop() {
			if (count == 0)
				return -1;
			int x = a[top--];
			count--;
			return x;
		}

		public int size() {
			return count;
		}

		public int isEmpty() {
			if (count == 0)
				return 1;
			else
				return 0;
		}

		public int top() {
			if (count == 0)
				return -1;
			else
				return a[top];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		Stack stack = new Stack(n);
		while (n > 0) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			String com = st.nextToken();
			switch (com) {
			case "push":
				String com2 = st.nextToken();
				int x = Integer.parseInt(com2);
				stack.push(x);
				break;
			case "top":
				System.out.println(stack.top());
				break;
			case "empty":
				System.out.println(stack.isEmpty());
				break;
			case "pop":
				System.out.println(stack.pop());
				break;
			case "size":
				System.out.println(stack.size());
				break;
			}
			--n;
		}

	}

}
