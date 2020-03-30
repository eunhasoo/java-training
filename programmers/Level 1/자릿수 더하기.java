class Solution {

	public int solution1(int n) {
		int answer = 0;
		String s = String.valueOf(n);
		for (int i = 0; i < s.length(); i++) {
			answer += Character.getNumericValue(s.charAt(i));
		}
		return answer;
	}

	public int solution2(int n) {
		int answer = 0;
		while (n > 0) {
			answer += n % 10;
			n /= 10;
		}
		return answer;
	}

}