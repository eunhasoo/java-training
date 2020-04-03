package baekjoon.no1261;

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

	int getWallCount(int[][] maze, int ROW, int COL) {
		int[][] direction = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.dist - n2.dist);
		queue.add(new Node(0, 0, 0));
		while (!queue.isEmpty()) {
			Node current = queue.remove();
			if (current.row == ROW - 1 && current.col == COL - 1) {
				return current.dist;
			}
			if (visited[current.row][current.col]) continue;
			visited[current.row][current.col] = true; 
			for(int[] d : direction) {
				int rowTo = current.row + d[0];
				int colTo = current.col + d[1];
				if (rowTo < 0 || rowTo >= ROW || colTo >= COL || colTo < 0) continue;
				if (visited[rowTo][colTo]) continue;
				queue.add(new Node(rowTo, colTo, current.dist + maze[rowTo][colTo]));
			}
		}
		return -1;
	}

	void start() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.valueOf(st.nextToken()); // col
		int M = Integer.valueOf(st.nextToken()); // row
		int[][] maze = new int[M][N];
		for (int i = 0; i < M; i++) {
			String s = reader.readLine();
			for (int j = 0; j < N; j++) {
				maze[i][j] = s.charAt(j) - '0'; // Character.getNumericValue(j)와 동일한 결과
			}
		}
		System.out.println(getWallCount(maze, M, N));
	}

	public static void main(String[] args) throws IOException {
		new Main().start();
	}

}
