class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] student = new int[n + 2]; // 비교용 배열
		for (int i : lost)
			student[i]--;
		for (int i : reserve)
			student[i]++;

		for (int i = 1; i < student.length - 1; i++) {
			if (student[i] > 0 && student[i - 1] < 0) { // 앞번호에서 체육복 분실시
				student[i]--;
				student[i - 1]++;
			}
			if (student[i] > 0 && student[i + 1] < 0) { // 뒷번호에서 체육복 분실시
				student[i]--;
				student[i + 1]++;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (student[i] >= 0)
				++answer;
		}
		return answer;
	}
}