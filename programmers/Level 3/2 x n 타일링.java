class Solution { // f(n) = f(n-2) + f(n-1) : 피보나치 이용
	public int solution(int n) {
		int a, b, c;
		a = b = 1;
		for (int i = 0; i <= (n - 2); i++) { // f(2)부터 시작
			c = (a + b) % 1000000007;
			a = b;
			b = c;
		}
		return b;
	}
}	