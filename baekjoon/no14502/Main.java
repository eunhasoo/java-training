package baekjoon.no14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	class Virus {
		int row, col;

		public Virus(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	List<Virus> virusList = new ArrayList<>();
	int[] dr = {0, -1, 1, 0};
	int[] dc = {1, 0, 0, -1};
	int safeCount = -3; // 벽을 세 개 세워야한다
	int answer = 0;

	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(st.nextToken()); // 지도의 세로길이
		int M = Integer.parseInt(st.nextToken()); // 지도의 가로길이
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 2) { // 바이러스면 리스트에 삽입
					virusList.add(new Virus(i, j));
				} else if (map[i][j] == 0) { // 안전영역이면 카운트
					safeCount++;
				}
			}
		}
		
		buildWalls(N, M, map);
		
		System.out.println(answer);
	}
	
	public void buildWalls(int N, int M, int[][] map) {
		int mapSize = N * M;
		
		for (int i = 0; i < mapSize - 2; i++) {
			if (map[i / M][i % M] > 0) continue;
			map[i / M][i % M] = 1; // 첫번째 벽 건설
			
			for (int j = i + 1; j < mapSize - 1; j++) {
				if (map[j / M][j % M] > 0) continue;
				map[j / M][j % M] = 1; // 두번째 벽 건설
				
				for (int k = j + 1; k < mapSize; k++) {
					if (map[k / M][k % M] > 0) continue;
					map[k / M][k % M] = 1; // 세번째 벽 건설
					
					spreadVirus(map); // 바이러스 퍼뜨리기
					
					map[k / M][k % M] = 0; // 되돌리기
				}
				
				map[j / M][j % M] = 0; // 되돌리기
			}
			
			map[i / M][i % M] = 0; // 되돌리기
		}
	}
	
	public void spreadVirus(int[][] map) {
		boolean[][] visited = new boolean[map.length][map[0].length];	
		Queue<Virus> queue = new ArrayDeque<>();
		int spreadCount = 0;
		
		for (int i = 0; i < virusList.size(); i++) {
			Virus virus = virusList.get(i);
			queue.add(virus);
			visited[virus.row][virus.col] = true;
		}
		
		while (!queue.isEmpty()) {
			Virus virus = queue.remove();
			
			for (int i = 0; i < 4; i++) {
				int rowTo = virus.row + dr[i];
				int colTo = virus.col + dc[i];
				
				if (rowTo < 0 || colTo < 0 || colTo >= map[0].length || rowTo >= map.length) continue;
				if (visited[rowTo][colTo] || map[rowTo][colTo] > 0) continue;
				
				++spreadCount;
				queue.add(new Virus(rowTo, colTo));
				visited[rowTo][colTo] = true;
			}
		}
		
		// (주어진 지도의 벽 개수(3)를 뺀 안전영역 수 - 퍼진 바이러스 수) = 벽이 건설된 후 안전영역 수
		answer = Math.max(answer, safeCount - spreadCount); 
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
