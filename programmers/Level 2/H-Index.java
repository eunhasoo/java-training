import java.util.Arrays;

class Solution {

	public int solution(int[] citations) {
		Arrays.sort(citations);

		for (int i = 0; i < citations.length; i++) {
			// 예) citations.length=5일 때, citations[i]회 이상 인용된 논문수는 (5-i)편
			int count = citations.length - i; 
			if (citations[i] - 1 == count) { // (배열값 - 1)회 이상 인용된 논문이 count편 존재하는 경우. 예) [5, 5, 5, 5]
				return citations[i] - 1; 
			}
			if (citations[i] >= count && i <= count) { // h회 이상 인용된 논문이 h편 이상 && 나머지 논문이 h편 이하
				return count;
			}
		}
		
		return 0;
	}
}