package baekjoon.no2178;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Location {
	int row;
	int col;
	int dist;
	
	public Location(int row, int col, int dist) {
		this.row = row;
		this.col = col;
		this.dist = dist;
	}
}

public class Main {

	static int search(char[][] maze, int ROW, int COL) {
		boolean[][] visited = new boolean[ROW][COL];
		Queue<Location> queue = new ArrayDeque<>();
		queue.add(new Location(0, 0, 1)); // 시작점부터 카운트한다
		while(!queue.isEmpty()) {
			Location current = queue.remove();
			if (current.row == (ROW - 1) && current.col == (COL - 1)) { // 도착하면
				return current.dist;
			}
			if ((0 > current.row || current.row >= ROW)
					|| (0 > current.col || current.col >= COL)) { // 행 또는 열 범위 초과시
				continue;
			}
			if (maze[current.row][current.col] == '0') { // 벽을 만났으면
				continue;
			}
			if (visited[current.row][current.col]) { // 이미 방문한 위치면
				continue;
			}
			visited[current.row][current.col] = true;
			
			queue.add(new Location(current.row + 1, current.col, current.dist + 1));
			queue.add(new Location(current.row, current.col + 1, current.dist + 1));
			queue.add(new Location(current.row - 1, current.col, current.dist + 1));
			queue.add(new Location(current.row, current.col - 1, current.dist + 1));
		}
		return -1;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		char[][] maze = new char[N][];
		for(int i=0; i < N; i++) {
			maze[i] = scan.next().toCharArray();
		}
		System.out.println(search(maze, N, M));
	}

}
