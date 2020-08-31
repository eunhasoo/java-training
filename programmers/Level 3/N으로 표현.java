class Solution {
    	int answer;

	public int solution(int N, int target) {
		answer = 9;
		dfs(N, target, 0, 0);
		if (answer == 9) return -1;
		return answer;
	}

	public void dfs(int N, int target, int number, int count) {
		if (count > 8) return;
		if (number == target) {
			if (count < answer) { // N 사용횟수가 최소값이면 갱신
				answer = count;
			}
			return;
		}
		
		int cal = 0;
		for (int i = 0; i < 5; i++) {
			cal = cal * 10 + N; // 5, 55, 555, ...
			dfs(N, target, number + cal, count + (1 + i));
			dfs(N, target, number - cal, count + (1 + i));
			dfs(N, target, number * cal, count + (1 + i));
			dfs(N, target, number / cal, count + (1 + i));
		}
	}
}