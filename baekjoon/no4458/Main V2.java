package baekjoon.no4458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	int[][] map;
	boolean[][] visited;
	PriorityQueue<Node> queue;
	int[][] directions = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

	class Node {
		int row, col, dist;

		public Node(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}

	int dijkstra(int destination) {
		visited = new boolean[map.length][map[0].length];
		queue = new PriorityQueue<>((n1, n2) -> n1.dist - n2.dist);
		queue.add(new Node(0, 0, map[0][0]));
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			Node current = queue.remove();
			if (current.row == destination && current.col == destination) { // 목적지 도착
				return current.dist;
			}
			for(int[] d : directions) {
				int rowTo = current.row + d[0];
				int colTo = current.col + d[1];
				if (rowTo < 0 || colTo < 0 || rowTo > destination || colTo > destination) continue;
				if (visited[rowTo][colTo]) continue;
				queue.add(new Node(rowTo, colTo, current.dist + map[rowTo][colTo]));
				visited[rowTo][colTo] = true;
			}
		}
		return -1;
	}

	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num = 1;
		while (true) {
			String s = reader.readLine();
			if (s.equals("0"))
				break;
			int N = Integer.valueOf(s);
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(reader.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.valueOf(st.nextToken());
				}
			}
			System.out.printf("Problem %d: %d\n", num++, dijkstra(N - 1));
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
