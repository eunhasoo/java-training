class Solution {  // 문제 포인트 : 3진수 이용
	public String solution(int n) {
		String[] nums = { "4", "1", "2" };
		String answer = "";
		int temp;
		while (n > 0) {
			temp = n % 3;
			answer = nums[temp] + answer;
			if (temp == 0) { // 예) n이 6이라면
				n = (n / 3) - 1; // 2(=6/3)가 아니라 1(=2-1)이 들어감
				continue;
			}
			n = n / 3;
		}
		return answer;
	}
}