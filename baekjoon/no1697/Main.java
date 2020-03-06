package baekjoon.no1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Node {
	int location;
	int time;
	
	public Node(int location, int time) {
		this.location = location;
		this.time = time;
	}
}

public class Main {
	static int MAX = 100000;
	
	static int BFS(int start, int end) {
		boolean[] isVisited = new boolean[MAX + 1]; // MAX값을 제대로 맞춰주지 않으면 런타임 에러 파티
		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.add(new Node(start, 0));
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			int location = node.location;
			int time = node.time;
			if (location == end) {
				return time;
			}
			if (location < 0 || location > MAX) continue;
			if (isVisited[location]) continue; 
			isVisited[location] = true;

			queue.add(new Node(location + 1, time + 1));
			queue.add(new Node(location - 1, time + 1));
			queue.add(new Node(location * 2, time + 1));
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int start = Integer.valueOf(st.nextToken());
		int end = Integer.valueOf(st.nextToken());
		System.out.println(BFS(start, end));
	}

}
