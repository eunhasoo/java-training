class Solution {
	public String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		int maxLength = number.length() - k;
		int start = 0, maxIdx, end;
		while (answer.length() < maxLength) {
			maxIdx = start;
			end = k + answer.length();
			for (int i = start + 1; i <= end; i++) {
				if (number.charAt(i) > number.charAt(maxIdx)) {
					maxIdx = i;
				}
			}
			answer.append(number.charAt(maxIdx));
			start = maxIdx + 1;
		}
		
		return answer.toString();
	}
}
