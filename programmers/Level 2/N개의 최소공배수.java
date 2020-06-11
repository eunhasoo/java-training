class Solution {

	// 최대 공약수 구하기
	int getGcd(int a, int b) {
		int big = (a > b) ? a : b;
		int small = (a > b) ? b : a;
		
		while (small != 0) {
			int r = big % small;
			big = small;
			small = r;
		}
		
		return big;
	}
	
	// 최소 공배수 구하기
	int getLcm(int a, int b) {
		return (a * b) / getGcd(a, b);
	}
	
	public int solution(int[] arr) {
		int res = arr[0];
		if (arr.length == 1) {
			return res;
		}

		// [a, b, c]에서 (a와 b의 최소공배수인) k와 c의 최소공배수 == a, b, c의 최소공배수

		for (int i = 1; i < arr.length; i++) {
			res = getLcm(res, arr[i]);
		}

		return res;
	}
}