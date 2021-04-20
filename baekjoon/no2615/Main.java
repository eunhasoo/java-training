package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	char[][] board;
	
	void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		board = new char[19][19];
		
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < 19; j++) {
				board[i][j] = st.nextToken().charAt(0);
			}
		}
		
		boolean found = false;
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (board[i][j] == '0') continue;
				
				if (isPossibleToWin(board[i][j], i, j)) {
					found = true;
					System.out.printf("%c\n%d %d", board[i][j], i + 1, j + 1);
					break;
				}
			}
			if (found) break;
		}
		
		if (!found) {
			System.out.println(0);
		}
	}
	
	boolean isSameColor(char color, int row, int col) {
		return (color == board[row][col]);
	}
	
	boolean checkRange(int r, int c) {
		if (r < 0 || c < 0 || r >= 19 || c >= 19) return false;
		return true;
	}
	
	boolean isValid(char color, int r, int c) {
		return checkRange(r, c) && isSameColor(color, r, c);
	}
	
	boolean isPossibleToWin(char color, int row, int col) {
		int toRow, toCol, toRightDown, toRightUp;
		toRow = toCol = toRightDown = toRightUp = 0;
		
		// 행 검사
		for (int i = 0; i < 5; i++) {
			if (!isValid(color, row + i, col)) break;
			++toRow;
		}
		
		if (toRow == 5) {
			if (checkRange(row - 1, col) && checkRange(row + 5, col)) {
				if (!isSameColor(color, row - 1, col) && !isSameColor(color, row + 5, col)) {
					return true;
				}
			} else if (checkRange(row - 1, col)) {
				if (!isSameColor(color, row - 1, col)) {
					return true;
				}
			} else if (checkRange(row + 5, col)) {
				if (!isSameColor(color, row + 5, col)) {
					return true;
				}
			}
		}
		
		// 열 검사
		for (int i = 0; i < 5; i++) {
			if (!isValid(color, row, col + i)) break;
			++toCol;
		}

		if (toCol == 5) {
			if (checkRange(row, col - 1) && checkRange(row, col + 5)) {
				if (!isSameColor(color, row, col - 1) && !isSameColor(color, row, col + 5)) {
					return true;
				}
			} else if (checkRange(row, col - 1)) {
				if (!isSameColor(color, row, col - 1)) {
					return true;
				}
			} else if (checkRange(row, col + 5)) {
				if (!isSameColor(color, row, col + 5)) {
					return true;
				}
			}
		}
		
		// 대각선 검사 (우하향)
		for (int i = 0; i < 5; i++) {
			if (!isValid(color, row + i, col + i)) break;
			++toRightDown;
		}
		
		if (toRightDown == 5) {
			if (checkRange(row - 1, col - 1) && checkRange(row + 5, col + 5)) {
				if (!isSameColor(color, row - 1, col - 1) && !isSameColor(color, row + 5, col + 5)) {
					return true;
				}
			} else if (checkRange(row - 1, col - 1)) {
				if (!isSameColor(color, row - 1, col - 1)) {
					return true;
				}
			} else if (checkRange(row + 5, col + 5)) {
				if (!isSameColor(color, row + 5, col + 5)) {
					return true;
				}
			}
		}
		
		// 대각선 검사 (우상향)
		for (int i = 0; i < 5; i++) {
			if (!isValid(color, row - i, col + i)) break;
			++toRightUp;
		}
		
		if (toRightUp == 5) {
			if (checkRange(row + 1, col - 1) && checkRange(row - 5, col + 5)) {
				if (!isSameColor(color, row + 1, col - 1) && !isSameColor(color, row - 5, col + 5)) {
					return true;
				}
			} else if (checkRange(row + 1, col - 1)) {
				if (!isSameColor(color, row + 1, col - 1)) {
					return true;
				}
			} else if (checkRange(row - 5, col + 5)) {
				if (!isSameColor(color, row - 5, col + 5)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}
}
