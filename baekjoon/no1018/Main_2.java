package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	char[][] whiteChessBoard = new char[8][8];
	char[][] blackChessBoard = new char[8][8];
	
	void makeTwoChessBoards() {
		boolean flag = true;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				whiteChessBoard[i][j] = (flag) ? 'W' : 'B';
				blackChessBoard[i][j] = (flag) ? 'B' : 'W';
				flag = !flag;
			}
			flag = !flag;
		}
	}

	int getRepaintCount(char[][] board, int r, int c) {
		int whiteCount = 0, blackCount = 0;
		for (int i = r; i < r + 8; i++) {
			for (int j = c; j < c + 8; j++) {
				if (board[i][j] != whiteChessBoard[i - r][j - c])
					++whiteCount;
				if (board[i][j] != blackChessBoard[i - r][j - c])
					++blackCount;
			}
		}
		return Math.min(whiteCount, blackCount);
	}

	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		char[][] board = new char[M][N];
		for (int i = 0; i < M; i++) {
			board[i] = reader.readLine().toCharArray();
		}

		makeTwoChessBoards();
		
		int minCount = 64;
		for (int i = 0; i <= M - 8; i++) {
			for (int j = 0; j <= N - 8; j++) {
				minCount = Math.min(minCount, getRepaintCount(board, i, j));
			}
		}

		System.out.println(minCount);
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
