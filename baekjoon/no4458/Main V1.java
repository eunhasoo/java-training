package baekjoon.no4458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	class Node {
		int row, col, dist;

		public Node(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}

	int dijkstra(int[][] map, int destination) {
		boolean[][] visited = new boolean[map.length][map[0].length];
		PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.dist - n2.dist);
		queue.add(new Node(0, 0, map[0][0]));
		while (!queue.isEmpty()) {
			Node current = queue.remove();
			int cRow = current.row;
			int cCol = current.col;
			int cDist = current.dist;
			if (cRow == destination && cCol == destination) { // 목적지 도착
				return cDist;
			}
			if (visited[cRow][cCol]) { // 이미 방문한 노드 처리
				continue;
			}
			visited[cRow][cCol] = true;

			if (cRow > 0)
				queue.add(new Node(cRow - 1, cCol, cDist + map[cRow - 1][cCol]));
			if (cCol > 0)
				queue.add(new Node(cRow, cCol - 1, cDist + map[cRow][cCol - 1]));
			if (cRow < destination)
				queue.add(new Node(cRow + 1, cCol, cDist + map[cRow + 1][cCol]));
			if (cCol < destination)
				queue.add(new Node(cRow, cCol + 1, cDist + map[cRow][cCol + 1]));
		}
		return -1;
	}

	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int count = 1;
		while (true) {
			String s = reader.readLine();
			if (s.equals("0"))
				break;
			int N = Integer.valueOf(s);
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(reader.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.valueOf(st.nextToken());
				}
			}
			System.out.printf("Problem %d: %d\n", count++, dijkstra(map, N - 1));
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
