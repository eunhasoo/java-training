package baekjoon.no1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	class Tree {

		class Node {
			char data;
			Node left, right;

			Node(char data) {
				this.data = data;
			}
		}
		
		Node root;

		public void add(char data, char left, char right) {
			if (root == null) {
				if (data != '.') root = new Node(data);
				if (left != '.') root.left = new Node(left);
				if (right != '.') root.right = new Node(right);
			} else {
				search(root, data, left, right);
			}
		}
		
		public void search(Node head, char data, char left, char right) {
			if (head == null) return;
			else if (head.data == data) {
				if (left != '.') head.left = new Node(left);
				if (right != '.') head.right = new Node(right);
			} else {
				search(head.left, data, left, right);
				search(head.right, data, left, right);
			}
		}
		
		public void preOrder(Node root) {
			if (root == null) return;
			
			System.out.print(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}

		public void postOrder(Node root) {
			if (root == null) return;
			
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data);
		}

		public void inOrder(Node root) {
			if (root == null) return;
			
			inOrder(root.left);
			System.out.print(root.data);
			inOrder(root.right);
		}
	}

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		Tree tree = new Tree();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(reader.readLine());
			char data = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			tree.add(data, left, right);
		}
		
		tree.preOrder(tree.root);
		System.out.println();
		
		tree.inOrder(tree.root);
		System.out.println();
		
		tree.postOrder(tree.root);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
