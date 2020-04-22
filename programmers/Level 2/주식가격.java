class Solution {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		int len = prices.length;
		int sec, money;
		for(int i = 0; i < len; i++) {
			sec = 0;
			money = prices[i];
			for(int j = i; j < (len - 1); j++) {
				if (money <= prices[j]) sec++;
				else break;
			}
			answer[i] = sec;
		}
		return answer;
	}
}