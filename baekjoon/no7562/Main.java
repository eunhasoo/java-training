package baekjoon.no7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Chess {
	int row;
	int col;
	int dist;
	
	public Chess(int row, int col, int dist) {
		this.row = row;
		this.col = col;
		this.dist = dist;
	}
}

public class Main {

	static int[][] moveRowAndCol = 
		{ {1, -2}, {2, -1}, {1, 2}, {2, 1}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2} };
	
	static int BFS(boolean[][] chessBoard, int rowFrom, int colFrom, int rowTo, int colTo) {
		final int ROW = chessBoard.length;
		final int COL = chessBoard[0].length;
		Queue<Chess> queue = new ArrayDeque<>();
		queue.add(new Chess(rowFrom, colFrom, 0));
		while (!queue.isEmpty()) {
			Chess chess = queue.remove();
			int row = chess.row, col = chess.col, dist = chess.dist;
			if (row == rowTo && col == colTo) {
				return dist;
			}
			if ((row < 0 || row >= ROW) || (col < 0 || col >= COL)) continue;
			if (chessBoard[row][col]) continue;
			chessBoard[row][col] = true;
			for(int[] d : moveRowAndCol) {
				int moveRow = row + d[0];
				int moveCol = col + d[1];
				if (moveRow < 0 || moveRow >= ROW) continue;
				if (moveCol < 0 || moveCol >= COL) continue;
				queue.add(new Chess(moveRow, moveCol, dist + 1));
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		int caseCnt = Integer.valueOf(reader.readLine());
		for (int i = 0; i < caseCnt; i++) {
			int size = Integer.valueOf(reader.readLine());
			boolean[][] chessBoard = new boolean[size][size];

			tokenizer = new StringTokenizer(reader.readLine());
			int rowFrom = Integer.valueOf(tokenizer.nextToken());
			int colFrom = Integer.valueOf(tokenizer.nextToken());

			tokenizer = new StringTokenizer(reader.readLine());
			int rowTo = Integer.valueOf(tokenizer.nextToken());
			int colTo = Integer.valueOf(tokenizer.nextToken());
			
			System.out.println(BFS(chessBoard, rowFrom, colFrom, rowTo, colTo));
		}
	}

}
