class Solution {

	public int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0)
				answer += i;
		}
		return answer + n; // 최대약수에 자기자신 포함
	}

}