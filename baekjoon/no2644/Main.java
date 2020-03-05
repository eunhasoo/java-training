package baekjoon.no2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
	int vertex;
	int distance;

	public Node(int vertex, int distance) {
		this.vertex = vertex;
		this.distance = distance;
	}
}

public class Main {
	
	public static int BFS(ArrayList<Integer>[] edges, int start, int end) {
		boolean[] isVisited = new boolean[edges.length];
		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.add(new Node(start, 0));
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			int current = node.vertex;
			int distance = node.distance;
			if (current == end) {
				return distance;
			}
			if (isVisited[current]) {
				continue;
			}
			isVisited[current] = true;
			for (int vertex : edges[current]) {
				if (isVisited[vertex]) {
					continue;
				}
				queue.add(new Node(vertex, distance + 1));
			}
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.valueOf(reader.readLine());
		ArrayList<Integer>[] edges = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			edges[i] = new ArrayList<>();
		}
		st = new StringTokenizer(reader.readLine());
		int start = Integer.valueOf(st.nextToken()) - 1;
		int end = Integer.valueOf(st.nextToken()) - 1;
		int m = Integer.valueOf(reader.readLine());
		while (m-- > 0) {
			st = new StringTokenizer(reader.readLine());
			int x = Integer.valueOf(st.nextToken()) - 1;
			int y = Integer.valueOf(st.nextToken()) - 1;
			edges[x].add(y);
			edges[y].add(x);
		}
		System.out.println(BFS(edges, start, end));
	}

}
