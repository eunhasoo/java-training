class Solution {
	int solution(int[][] board) {
		int row = board.length;
		int col = board[0].length;
		
		int leftUp, left, up, current;
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				leftUp = board[i - 1][j - 1];
				left = board[i][j - 1];
				up = board[i - 1][j];
				current = board[i][j];
				
				// 왼쪽, 왼쪽 위, 바로 위, 현재 값을 비교해서 1 이상인지 확인하고
				// 그중 제일 작은 값에 1을 더해서 현재 위치에 한 변의 길이값을 저장한다
				if (leftUp >= 1 && left >= 1 && up >= 1 && current >= 1) {
					board[i][j] = Math.min(leftUp, Math.min(left, up)) + 1;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				max = Math.max(board[i][j], max);
			}
		}
		
		// 정사각형의 넓이를 리턴한다
		return max * max;
	}
}