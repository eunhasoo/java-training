class Solution {
	int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	
	int lcm(int n, int m) {
		return (n * m) / gcd(n, m);
	}
	
	public int[] solution(int n, int m) {
		int[] answer = new int[2];
		answer[0] = gcd(n, m);
		answer[1] = lcm(n, m);
		return answer;
	}
}