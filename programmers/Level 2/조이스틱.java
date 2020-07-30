class Solution {

	public int solution(String name) {
		// 상하 조작 횟수는 그냥 계산해서 저장
		int[] alpha = new int[name.length()];
		for (int i = 0; i < alpha.length; i++) {
			char c = name.charAt(i);
			alpha[i] = (c - 'A') < ('Z' - c + 1) ? (c - 'A') : ('Z' - c + 1);
		}
		int movedAlphaCnt = 0;
		for (int upDown : alpha)
			movedAlphaCnt += upDown;
		
		// 좌우 조작은 최소로 움직인 횟수를 찾아야 한다
		int movedCursorCnt = name.length() - 1; 
		for (int i = 0; i < alpha.length; i++) {
			int idx = i;
			if (alpha[idx] == 0) { // 해당 인덱스부터 시작해서
				// 연속되는 A의 개수를 센다
				while (idx < alpha.length && alpha[idx] == 0) { 
					++idx;
				}
				int cnt = ((i - 1) * 2) + name.length() - idx;
				movedCursorCnt = Math.min(movedCursorCnt, cnt);
			}
		}
		
		return movedAlphaCnt + movedCursorCnt;
	}
}