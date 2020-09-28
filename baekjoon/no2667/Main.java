package baekjoon.no2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	boolean[][] visited;
	char[][] map;
	int count;
	int[][] directions = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
	
	public void dfs(int x, int y) {
		++count;
		visited[x][y] = true;
		
		for (int[] d : directions) {
			int xTo = x + d[0];
			int yTo = y + d[1];
			
			if (xTo < 0 || yTo < 0 || 
					yTo > map.length - 1 || xTo > map.length - 1) continue;
			if (visited[xTo][yTo] || map[xTo][yTo] == '0') continue;
			
			dfs(xTo, yTo);
		}
		
	}

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = reader.readLine().toCharArray();
		}
		List<Integer> houseCountList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1' && !visited[i][j]) {
					count = 0;
					dfs(i, j);
					houseCountList.add(count);
				}
			}
		}
		
		Collections.sort(houseCountList);
		
		System.out.println(houseCountList.size());
		for (int i = 0; i < houseCountList.size(); i++) {
			System.out.println(houseCountList.get(i));
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}
