import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BinarySearchTree bst = new BinarySearchTree();

        while (true) {
            String s = reader.readLine();
            if (s == null || s.length() == 0) break;
            bst.insert(Integer.parseInt(s));
        }

        bst.postorder(bst.root);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}

class BinarySearchTree {

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root = null;

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        search(root, data);
    }

    public void search(Node head, int data) {
        if (head.data > data) {
            if (head.left == null) {
                head.left = new Node(data);
                return;
            }
            search(head.left, data);
        } else {
            if (head.right == null) {
                head.right = new Node(data);
                return;
            }
            search(head.right, data);
        }
    }

    public void postorder(Node head) {
        if (head.left == null) postorder(head.left);
        if (head.right == null) postorder(head.right);
        System.out.println(head.data);
    }
}