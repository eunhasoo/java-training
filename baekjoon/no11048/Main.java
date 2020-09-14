package baekjoon.no11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public void makeMaxMaze(int[][] maze) {
		for (int i = 1; i < maze.length; i++) {
			for (int j = 1; j < maze[0].length; j++) {
				int max = Math.max(maze[i][j - 1], Math.max(maze[i - 1][j], maze[i - 1][j - 1]));
				maze[i][j] += max;
			}
		}
	}

	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] maze = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 1; j <= M; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeMaxMaze(maze);
		System.out.println(maze[N][M]);
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
