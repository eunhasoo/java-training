import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

	public int solution(int[][] board/* N x N */, int[] moves) {
		Deque<Integer> stack = new ArrayDeque<>();
		int boardLen = board.length;
		int movesLen = moves.length;
		int answer = 0;
		for (int i = 0; i < movesLen; i++) { // 크레인으로 옮기는 작업마다
			Integer now = stack.peekLast(); // 현재 바구니 최상단에 있는 인형 번호 저장
			
			for (int j = 0; j < boardLen; j++) {
				// ※ 열이 아니라 [행]을 이동해야함! 문제를 잘 읽자..
				// 바구니에 넣을 인형 번호
				int next = board[j][moves[i] - 1]; 
				if (next == 0) // 빈칸이면 다음 칸으로 바로 이동
					continue; 
				board[j][moves[i] - 1] = 0; // 꺼낸 인형 빈칸으로 표시
				if (now != null && now == next) { // 바구니의 인형과 일치하는 인형이면
					stack.removeLast(); 
					answer += 2;
					break;
				}
				// 인형이 일치하지 않거나 바구니가 비었으면
				stack.addLast(next);
				break;
			}
		}
		return answer;
	}

}