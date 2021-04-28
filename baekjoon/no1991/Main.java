import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    class Tree {

        class Node {
            char data;
            Node leftChild, rightChild;

            public Node(char data) {
                this.data = data;
            }
        }

        Node root = null;

        public void insert(char data, char leftChild, char rightChild) {
            if (root == null) {
                root = new Node(data);
                root.leftChild = new Node(leftChild);
                root.rightChild = new Node(rightChild);
                return;
            }

            search(root, data, leftChild, rightChild);
        }

        public void search(Node head, char data, char leftChild, char rightChild) {
            if (head == null || head.data == '.') return;

            if (head.data == data) {
                if (leftChild != '.') head.leftChild = new Node(leftChild);
                if (rightChild != '.') head.rightChild = new Node(rightChild);
                return;
            }

            search(head.leftChild, data, leftChild, rightChild);
            search(head.rightChild, data, leftChild, rightChild);
        }

        public void preorder(Node node) {
            if (node == null || node.data == '.') return;
            System.out.print(node.data);
            preorder(node.leftChild);
            preorder(node.rightChild);
        }

        public void inorder(Node node) {
            if (node == null || node.data == '.') return;
            inorder(node.leftChild);
            System.out.print(node.data);
            inorder(node.rightChild);
        }

        public void postorder(Node node) {
            if (node == null || node.data == '.') return;
            postorder(node.leftChild);
            postorder(node.rightChild);
            System.out.print(node.data);
        }
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Tree tree = new Tree();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            char data = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);
            tree.insert(data, leftChild, rightChild);
        }

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}