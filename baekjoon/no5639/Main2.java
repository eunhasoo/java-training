// 후위순회를 입력으로 받아 전위순회로 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Node {
	int value;
	Node left, right;
	
	Node(int value) {
		this.value = value;
	}
	
	void printPreOrder() {
		System.out.printf("%d ", this.value);
		if (left != null) {
			left.printPreOrder();
		}
		if (right != null) {
			right.printPreOrder();
		}
	}
}

public class Main {
	
	static ArrayDeque<Integer> postList = new ArrayDeque<>();
	
	static Node buildTree(int min, int max) { // 후위순회로부터 트리화
		if (postList.size() == 0) {
			return null;
		}
		int value = postList.getLast(); // 맨뒤에 있는 값이 루트노드
		if (value < min || value > max) {
			return null;
		}
		postList.removeLast();
		Node node = new Node(value);
		node.right = buildTree(node.value, max);
		node.left = buildTree(min, node.value);
		return node;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input = reader.readLine();
			if (input == null || input.trim().length() == 0) {
				break;
			}
			postList.add(Integer.valueOf(input));
		}
		Node rootNode = buildTree(Integer.MIN_VALUE, Integer.MAX_VALUE);
		rootNode.printPreOrder();
	}

}
