package baekjoon.no14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	char[][] map;
	// 	    북, 동, 남, 서
	int[] dy = { -1, 0, 1,  0 }; 
	int[] dx = {  0, 1, 0, -1 };
	
	class RobotsWay {
		int row, col, direction;

		public RobotsWay(int row, int col, int direction) {
			this.row = row;
			this.col = col;
			this.direction = direction;
		}
	}
	
	public int operate(int row, int col, int direction) {
		Queue<RobotsWay> queue = new ArrayDeque<>();
		queue.add(new RobotsWay(row, col, direction));
		int blockCount = 0;

		while (!queue.isEmpty()) {
			RobotsWay way = queue.remove();
			if (map[way.row][way.col] == '0') {
				++blockCount;
				map[way.row][way.col] = '.';
			}

			// 왼쪽 방향으로 회전하면서 전진하는 경우
			for (int dir = 0; dir < 4; dir++) { 
				int dirTo = (way.direction + 3 - dir) % 4; // 북-서-남-동 순으로 회전해야 함
				int rowTo = way.row + dy[dirTo];
				int colTo = way.col + dx[dirTo];
				
				if (rowTo < 0 || colTo < 0 || colTo > map[0].length - 1 || rowTo > map.length - 1) continue;
				if (map[rowTo][colTo] != '0') continue; // 벽이 아니고 청소하지 않은 구역으로만 이동
				
				queue.add(new RobotsWay(rowTo, colTo, dirTo));
				break;
			}
			
			// 후진해야 하는 경우
			if (queue.isEmpty()) { 
				int dirTo = way.direction; // 바라보는 방향은 유지한 채로
				int rowTo = way.row + dy[(dirTo + 2) % 4]; // 북↔남 혹은 동↔서 칸 이동
				int colTo = way.col + dx[(dirTo + 2) % 4];
				
				if (rowTo < 0 || colTo < 0 || colTo > map[0].length - 1 || rowTo > map.length - 1) break;
				if (map[rowTo][colTo] == '1') break; // 벽인 경우만 후진 불가 (이미 청소한 곳은 다시 청소하지 않을뿐 후진은 가능함)

				queue.add(new RobotsWay(rowTo, colTo, dirTo));
			}
		}

		// 작동 중지
		return blockCount;
	}

	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(st.nextToken()); // 세로 크기 (row)
		int M = Integer.parseInt(st.nextToken()); // 가로 크기 (col)
		map = new char[N][M];
		
		st = new StringTokenizer(reader.readLine());
		int r = Integer.parseInt(st.nextToken()); // 로봇 청소기 시작 행
		int c = Integer.parseInt(st.nextToken()); // 로봇 청소기 시작 열
		int d = Integer.parseInt(st.nextToken()); // 로봇 청소기 시작 방향
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; st.hasMoreTokens(); j++)
				map[i][j] = st.nextToken().charAt(0);
		}
		
		System.out.println(operate(r, c, d));
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}