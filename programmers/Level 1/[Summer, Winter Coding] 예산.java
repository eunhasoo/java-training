import java.util.Arrays;

class Solution {

	public int solution(int[] d, int budget) {
		Arrays.sort(d); // 적은 예산부터 먼저 접근할 수 있도록 정렬한다
		
		int count = 0;
		for(int i = 0; i < d.length; i++) {
			if (budget >= d[i]) { // 예산금액이 나눌만큼 있다면
				budget -= d[i];	// 금액만큼 나눠주고 카운트 증가
				++count;
				continue;
			}
			break; // 더 이상 예산을 나눠줄수 없으면 반복 종료
		}
		
		return count;
	}

}