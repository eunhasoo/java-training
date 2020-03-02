package baekjoon.no5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Node {
	int value;
	Node left, right;

	public Node(int value) {
		this.value = value;
	}

	// 이진트리를 후위순회하여 출력한다
	public void printPostOrder() {
		if (left != null) {
			left.printPostOrder();
		}
		if (right != null) {
			right.printPostOrder();
		}
		System.out.printf("%d \n", value);
	}
}

public class Main {

	// 입력받은 전위순회 출력결과를 담은 객체
	static ArrayDeque<Integer> deque = new ArrayDeque<>();

	// 입력받은 전위순회 결과로부터 이진트리를 만든다
	static Node buildTree(int min, int max) {
		if (deque.size() == 0) {
			return null;
		}
		int value = deque.getFirst(); // 전위순회는 루트노드가 맨앞에 있으므로 앞에서부터 확인
		if (value < min || value > max) { // 유효범위가 아니면 작업하지않고 리턴
			return null;
		}
		deque.removeFirst();
		Node node = new Node(value);
		node.left = buildTree(min, node.value);
		node.right = buildTree(node.value, max);
		return node;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input = reader.readLine();
			if (input == null || input.trim().length() == 0) { // 빈 String이면 읽기를 끝낸다
				break;
			}
			deque.addLast(Integer.valueOf(input));
		}
		Node rootNode = buildTree(Integer.MIN_VALUE, Integer.MAX_VALUE);
		rootNode.printPostOrder();
	}

}
