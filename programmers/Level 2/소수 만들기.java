class Solution {
	
	int answer = 0;
	
	public int solution(int[] numbers) {
		int r = 3;
		combination(numbers, new boolean[numbers.length], 0, numbers.length, r);
		return answer;
	}
	
	public void combination(int[] numbers, boolean[] visited, int start, int end, int r) {
		if (r == 0) {
			int num = sum(numbers, visited, end);
			if (isPrimeNum(num)) 
				++answer;
			return;
		}
		
		for (int i = start; i < end; i++) {
			visited[i] = true;
			combination(numbers, visited, i + 1, end, r - 1);
			visited[i] = false;
		}
	}
	
	public boolean isPrimeNum(int num) {
		if (num == 1) return false;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) 
				return false;
		}
		return true;
	}
	
	public int sum(int[] numbers, boolean[] visited, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i])
				sum += numbers[i];
		}
		return sum;
	}
}