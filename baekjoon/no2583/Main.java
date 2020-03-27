package baekjoon.no2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	int ROW, COL;
	boolean[][] isVisited;
	int[][] paper;
	int[] dx = { 1, 0 , -1, 0 };
	int[] dy = { 0, 1, 0, -1 };
	int area;
	
	public void DFS(int row, int col) {
		area++;
		isVisited[row][col] = true;
		for (int i = 0; i < 4; i++) {
			int rowTo = row + dx[i];
			int colTo = col + dy[i];
			if (rowTo < ROW && colTo < COL && rowTo >= 0 && colTo >= 0) 
				if (!isVisited[rowTo][colTo] && paper[rowTo][colTo] == 0)
					DFS(rowTo, colTo);
		}
	}

	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		ROW = Integer.parseInt(st.nextToken());
		COL = Integer.parseInt(st.nextToken());
		paper = new int[ROW][COL];
		isVisited = new boolean[ROW][COL];
		int loop = Integer.parseInt(st.nextToken());
		while (loop-- > 0) {
			st = new StringTokenizer(reader.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			for (int i = r1; i < r2; i++) {
				for (int j = c1; j < c2; j++) {
					paper[i][j] = 1;
				}
			}
		}
		List<Integer> areas = new ArrayList<>();
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (!isVisited[i][j] && paper[i][j] == 0) {
					area = 0;
					DFS(i, j);
					areas.add(area);
				}
			}
		}
		Collections.sort(areas);
		System.out.println(areas.size());
		for (int area : areas)
			System.out.printf("%d ", area);
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
