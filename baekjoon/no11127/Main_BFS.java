import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	int[][] field;
	boolean[][] visited;
	int[][] direction = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
	
	class Position {
		int row, col;

		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public void bfs(Queue<Position> queue) {
		while (!queue.isEmpty()) {
			Position now = queue.remove();
			for (int[] d : direction) {
				int rowTo = now.row + d[0];
				int colTo = now.col + d[1];
				if (rowTo < 0 || colTo < 0 
						|| rowTo > field.length - 1 || colTo > field[0].length - 1) continue;
				if (visited[rowTo][colTo] || field[rowTo][colTo] == 0) continue;
				
				queue.add(new Position(rowTo, colTo));
				visited[rowTo][colTo] = true;
			}
		}
	}

	public void run() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		StringTokenizer st;
		while (T-- > 0) {
			st = new StringTokenizer(reader.readLine());
			int M = Integer.parseInt(st.nextToken()); // 배추밭 가로 길이
			int N = Integer.parseInt(st.nextToken()); // 배추밭 세로 길이
			int K = Integer.parseInt(st.nextToken()); // 배추가 심어진 위치 수
			field = new int[M][N];
			visited = new boolean[M][N];
			
			int r, c;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(reader.readLine());
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				field[r][c] = 1;
			}
			
			Queue<Position> queue = new ArrayDeque<>();
			int count = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && field[i][j] == 1) {
						++count;
						queue.add(new Position(i, j));
						visited[i][j] = true;
						bfs(queue);
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().run();
	}

}