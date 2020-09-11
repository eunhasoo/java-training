class Solution {
	
	public void removeAndMoveBlocks(char[][] copy) {
		for (int col = 0; col < copy[0].length; col++) {
			for (int j = copy.length - 2; j >= 0; j--) {
				for (int row = j; row < copy.length - 1; row++) {
					if (Character.isUpperCase(copy[row + 1][col])) // 아래 블럭이 대문자면 반복 종료
						break;
					copy[row + 1][col] = copy[row][col]; // 한 줄 아래로 블럭 이동
					copy[row][col] = ' '; // 해당 블럭 삭제
				}
			}
		}
	}

	public boolean isSame(char x, char y) {
		return Character.toUpperCase(x) == Character.toUpperCase(y);
	}

	public int solution(int m, int n, String[] board) {
		char[][] copy = new char[m][n];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = board[i].toCharArray();
		}

		int count = 0;
		boolean flag = true;
		do {
			flag = false;
			
			for (int row = 0; row < m - 1; row++) {
				for (int col = 0; col < n - 1; col++) {
					if (copy[row][col] == ' ')
						continue;

					// 2 x 2 블럭 완성 체크
					if (isSame(copy[row][col], copy[row + 1][col]) 
							&& isSame(copy[row][col], copy[row][col + 1])
							&& isSame(copy[row][col], copy[row + 1][col + 1])) {

						// 대문자인 경우에만 소문자화 및 카운트
						if (Character.isUpperCase(copy[row][col])) {
							copy[row][col] += 32;
							count++;
						}
						if (Character.isUpperCase(copy[row + 1][col])) {
							copy[row + 1][col] += 32;
							count++;
						}
						if (Character.isUpperCase(copy[row][col + 1])) {
							copy[row][col + 1] += 32;
							count++;
						}
						if (Character.isUpperCase(copy[row + 1][col + 1])) {
							copy[row + 1][col + 1] += 32;
							count++;
						}
						
						flag = true;
					}
				}
			}
			
			if (flag) removeAndMoveBlocks(copy);
		} while (flag);
		
		return count;
	}
}